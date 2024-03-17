package com.fiap.zerodengue.views.vistoriador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistoriadorViewModel: ViewModel() {
    private val _tabIndex = MutableLiveData<Int>()
    val tabIndex: LiveData<Int> = _tabIndex

    val tabs = listOf("Entrar", "Cadastrar")

    fun onTabIndexChanged(newIndexValue: Int){
        _tabIndex.value = newIndexValue
    }
}