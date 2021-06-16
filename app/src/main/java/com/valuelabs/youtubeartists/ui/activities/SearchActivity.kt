package com.valuelabs.youtubeartists.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.valuelabs.youtubeartists.BuildConfig
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.ActivitySearchBinding
import com.valuelabs.youtubeartists.models.VideoItem
import com.valuelabs.youtubeartists.models.YoutubeSearchRequestModel
import com.valuelabs.youtubeartists.ui.adapters.SearchAdapter
import com.valuelabs.youtubeartists.ui.view.showLongToast
import com.valuelabs.youtubeartists.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchActivity : RootActivity(), SearchAdapter.SearchItemClickListener {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchItemBinding =
            DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search)
        setupSearchRecyclerView(searchItemBinding)
        setupSearchAction(searchItemBinding)
        observeData(searchItemBinding)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupSearchAction(searchItemBinding: ActivitySearchBinding) {
        searchItemBinding.searchEditText.setOnTouchListener(OnTouchListener { _, event ->
            val drawableRight = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= searchItemBinding.searchEditText.right - searchItemBinding.searchEditText.compoundDrawables[drawableRight].bounds.width()
                ) {
                    val query = searchItemBinding.searchEditText.text.toString().trim()
                    if (query.isNotEmpty()) {
                        val request =
                            YoutubeSearchRequestModel(
                                apiKey = BuildConfig.API_KEY,
                                query,
                                25,
                                "snippet"
                            )
                        searchViewModel.getYoutubeSearchResult(request)
                    } else {
                        showLongToast("Please enter something")
                    }
                    return@OnTouchListener true
                }
            }
            return@OnTouchListener false
        })
    }

    private fun setupSearchRecyclerView(searchItemBinding: ActivitySearchBinding) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val searchAdapter = SearchAdapter()
        searchAdapter.setSearchItemClickListener(this)
        searchItemBinding.searchResultRecyclerView.layoutManager = linearLayoutManager
        searchItemBinding.searchResultRecyclerView.adapter = searchAdapter
    }

    private fun observeData(searchItemBinding: ActivitySearchBinding) {
        searchViewModel.loadingLiveData.observe(this, {
            searchItemBinding.loader.isVisible = it
        })
        searchViewModel.errorLiveData.observe(this, {
            showLongToast(it)
        })
        searchViewModel.searchResultLiveDataModel.observe(this, {
            it?.items?.apply {
                if (isNotEmpty()) {
                    (searchItemBinding.searchResultRecyclerView.adapter as SearchAdapter).populateList(
                        this
                    )
                }
            }
        })
    }

    override fun onSearchItemClick(videoItem: VideoItem) {
        videoItem.id?.let {
            it.videoId?.let { videoId ->
                if (videoId.isNotEmpty()) startActivity(MainActivity.buildIntent(this, videoId))
            }
        }
    }

    companion object {
        fun buildIntent(from: Context): Intent = Intent(from, SearchActivity::class.java)
    }
}