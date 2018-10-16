package com.samples.koinsample

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module.module

val appModule = module {

    single { get<Application>().getSharedPreferences("AppPreference", Context.MODE_PRIVATE) }

    single("SingletonValue") {
        get<SharedPreferences>().getString("name", "Non")
    }

    factory("FactoryValue") {
        get<SharedPreferences>().getString("name", "Non")
    }

    factory("Child1") { Child("Ahmed") }

    factory("Child2") { Child("Ahmed2") }

    factory("Parent1") { Parent("Mohamed", get("Child1")) }

    factory("Parent2") { Parent("Anything", get("Child2")) }
}