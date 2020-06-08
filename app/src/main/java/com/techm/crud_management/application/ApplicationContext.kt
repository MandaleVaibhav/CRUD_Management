package com.techm.crud_management.application

import android.app.Application
import android.content.Context

/**
 * This class for creating creating com.techm.crud_management.application context
 */
class ApplicationContext : Application() {

    companion object {
        lateinit var context: Context
    }

    /**
     * This method is used to initialize the context
     */
    override fun onCreate() {
        super.onCreate()
        context = this

    }
}