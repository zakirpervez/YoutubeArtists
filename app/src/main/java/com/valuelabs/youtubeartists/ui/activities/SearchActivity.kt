package com.valuelabs.youtubeartists.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.ActivitySearchBinding
import com.valuelabs.youtubeartists.models.VideoItem
import com.valuelabs.youtubeartists.ui.adapters.SearchAdapter
import com.valuelabs.youtubeartists.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : RootActivity(), SearchAdapter.SearchItemClickListener {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchItemBinding =
            DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search)
    }

    override fun onSearchItemClick(videoItem: VideoItem) {

    }
}