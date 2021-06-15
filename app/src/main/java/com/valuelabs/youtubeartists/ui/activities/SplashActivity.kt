package com.valuelabs.youtubeartists.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : RootActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashBinding =
            DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        navigateToMain()
    }

    private fun navigateToMain() {
        activityScope.launch {
            delay(SPLASH_DELAY)
            startActivity(MainActivity.buildIntent(this@SplashActivity))
            finish()
        }
    }

    companion object {
        private const val SPLASH_DELAY = 3000L
    }
}
