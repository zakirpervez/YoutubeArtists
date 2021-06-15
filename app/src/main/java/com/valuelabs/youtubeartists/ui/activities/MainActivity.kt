package com.valuelabs.youtubeartists.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.valuelabs.youtubeartists.R
import com.valuelabs.youtubeartists.databinding.ActivityMainBinding
import com.valuelabs.youtubeartists.models.TempModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : RootActivity() {
    @Inject
    lateinit var tempModel: TempModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainBinding.greetTextView.text = tempModel.greet
    }
}
