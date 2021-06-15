package com.valuelabs.youtubeartists

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class YoutubeArtistsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
