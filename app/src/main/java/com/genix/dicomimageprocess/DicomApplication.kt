package com.genix.dicomimageprocess

import android.app.Application

class DicomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        System.loadLibrary("imebra_lib")
    }
}