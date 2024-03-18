package com.fiap.zerodengue.view.vistoriador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiap.zerodengue.data.AuthRepository
import kotlinx.coroutines.launch

class VistoriadorViewModel: ViewModel() {
    private val _tabIndex = MutableLiveData<Int>()
    val tabIndex: LiveData<Int> = _tabIndex

    val tabs = listOf("Entrar", "Cadastrar")

    fun onTabIndexChanged(newIndexValue: Int){
        _tabIndex.value = newIndexValue
    }

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun onNameChanged(newNameValue: String){
        _name.value = newNameValue
    }

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChanged(newEmailValue: String){
        _email.value = newEmailValue
    }

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onPasswordChanged(newPasswordValue: String){
        _password.value = newPasswordValue
    }

    private val authRepository: AuthRepository = AuthRepository()
    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ){
        viewModelScope.launch {
            val result = authRepository.login(email, password)
            if(result.isSuccess){
                val userType = result.getOrNull()
                if(userType == "vistoriador") onSuccess()
                else onFailed()
            }else {
                onFailed()
            }
        }
    }
    fun register(
        email: String,
        password: String,
        name: String,
        userType: String = "vistoriador",
        onSuccess: () -> Unit,
        onFailed: () -> Unit
    ){
        viewModelScope.launch {
            val result = authRepository.register(email, password, name, userType)
            if(result.isSuccess) onSuccess()
            else onFailed()
        }
    }

}