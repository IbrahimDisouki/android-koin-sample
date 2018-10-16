package com.samples.koinsample

import android.util.Log

data class Child(var name: String) {

    fun logName() {
        Log.i("CHILD", name)
    }

}