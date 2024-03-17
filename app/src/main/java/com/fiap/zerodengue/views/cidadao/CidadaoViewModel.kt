package com.fiap.zerodengue.views.cidadao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CidadaoViewModel: ViewModel() {
    private val _tabIndex = MutableLiveData<Int>()
    val tabIndex: LiveData<Int> = _tabIndex

    val tabs = listOf("Entrar", "Cadastrar")

    fun onTabIndexChanged(newIndexValue: Int){
        _tabIndex.value = newIndexValue
    }
}