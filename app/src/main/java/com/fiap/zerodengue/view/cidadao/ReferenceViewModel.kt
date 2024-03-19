package com.fiap.zerodengue.view.cidadao

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReferenceViewModel: ViewModel() {
    private val _selectedImageUri = mutableStateOf<Uri?>(null)
    val selectedImageUri: State<Uri?> = _selectedImageUri

    fun setSelectedImageUri(uri: Uri?) {
        _selectedImageUri.value = uri
    }

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    fun onAddressChanged(newAddressValue: String){
        _address.value = newAddressValue
    }

    private val _refPoint = MutableLiveData<String>()
    val refPoint: LiveData<String> = _refPoint

    fun onRefPointChanged(newRefPointValue: String){
        _refPoint.value = newRefPointValue
    }

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    fun onDescriptionChanged(newDescriptionValue: String){
        _description.value = newDescriptionValue
    }


}