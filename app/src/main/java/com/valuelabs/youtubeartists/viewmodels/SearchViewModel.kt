package com.valuelabs.youtubeartists.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ofroad.android.app.exceptions.ApiException
import com.valuelabs.youtubeartists.models.YoutubeSearchRequestModel
import com.valuelabs.youtubeartists.models.YoutubeSearchResponseModel
import com.valuelabs.youtubeartists.network.Repository
import com.valuelabs.youtubeartists.util.UNIVERSAL_ERROR_MESSAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(val repository: Repository) :
    RootViewModel() {
    private val searchResultMutableLiveData: MutableLiveData<YoutubeSearchResponseModel> =
        MutableLiveData()
    val searchResultLiveData: LiveData<YoutubeSearchResponseModel> = searchResultMutableLiveData

    fun getYoutubeSearchResult(requestModel: YoutubeSearchRequestModel) =
        viewModelScope.launch(Dispatchers.IO) {
            try {
                loadingMutableLiveData.postValue(true)
                val response = repository.getYoutubeSearchResult(requestModel)
                searchResultMutableLiveData.postValue(response)
            } catch (e: ApiException) {
                errorMutableLiveData.postValue(e.message ?: UNIVERSAL_ERROR_MESSAGE)
            } catch (e: NullPointerException) {
                errorMutableLiveData.postValue(e.message ?: UNIVERSAL_ERROR_MESSAGE)
            } finally {
                loadingMutableLiveData.postValue(false)
            }
        }
}