package com.valuelabs.youtubeartists.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class RootViewModel : ViewModel() {
    protected val _loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = _loadingMutableLiveData
    protected val _errorMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String> = _errorMutableLiveData
}
