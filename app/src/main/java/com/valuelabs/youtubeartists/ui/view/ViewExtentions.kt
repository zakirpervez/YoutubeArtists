package com.valuelabs.youtubeartists.ui.view

import android.content.Context
import android.widget.Toast

fun Context.showLongToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}