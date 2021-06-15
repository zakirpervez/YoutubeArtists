package com.valuelabs.youtubeartists.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class RootViewModel : ViewModel() {
    protected val loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = loadingMutableLiveData
    protected val errorMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String> = errorMutableLiveData
}
