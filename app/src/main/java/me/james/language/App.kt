package me.james.language

import android.app.Application

/**
 * copyright：
 * author： James
 * date：2019/4/11 15:25
 * description：
 */
class App:Application() {

    companion object {
        var instance:App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}