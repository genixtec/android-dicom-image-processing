package com.genix.dicomimageprocess

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = Utils.getFile(this, "MRBRAIN.DCM")

        val loadedDataSet = com.imebra.CodecFactory
                .load(file.absolutePath, 2048)

        // Retrieve the first image (index = 0)
        val image = loadedDataSet.getImageApplyModalityTransform(0)

        // Get the color space
        val colorSpace = image.colorSpace

        // Get the size in pixels
        val width = image.width
        val height = image.height
        val chain = Utils.applyTransformation(colorSpace, loadedDataSet,
                image, width, height)
        renderImage.setImageBitmap(Utils.generateBitmap(chain, image))
    }
}
