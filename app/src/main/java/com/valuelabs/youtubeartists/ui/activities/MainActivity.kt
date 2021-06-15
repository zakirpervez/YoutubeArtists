package com.valuelabs.youtubeartists.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.valuelabs.youtubeartists.BuildConfig
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.ActivityMainBinding
import com.valuelabs.youtubeartists.ui.view.showLongToast

class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupYoutubePlayer(mainBinding)
    }

    private fun setupYoutubePlayer(mainBinding: ActivityMainBinding) {
        val youtubeInitListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                p2: Boolean
            ) {
                player?.loadVideo("VQttXb6qE6k")
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider?,
                result: YouTubeInitializationResult?
            ) {
                showLongToast("Something went wrong")
            }
        }
        mainBinding.playButton.setOnClickListener {
            mainBinding.youtubePlayerView.initialize(
                BuildConfig.API_KEY,
                youtubeInitListener
            )
        }
    }

    companion object {
        fun buildIntent(from: Context): Intent {
            return Intent(from, MainActivity::class.java)
        }
    }
}
