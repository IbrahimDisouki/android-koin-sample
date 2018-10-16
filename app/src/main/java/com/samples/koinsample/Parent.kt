package com.samples.koinsample

import android.util.Log

data class Parent(var name: String, var child: Child) {

    fun logFullName() {
        Log.i("PARENT", "${child.name} $name")
    }

}