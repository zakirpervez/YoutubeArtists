package com.valuelabs.youtubeartists

import timber.log.Timber

open class YoutubeArtistsDebugApplication : YoutubeArtistsApplication() {
    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
        Timber.e("**********************YoutubeArtistsDebugApplication started******************")
    }
}