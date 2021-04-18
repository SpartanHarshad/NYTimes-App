package com.example.nytimes.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View


class BitMapCreator {

    companion object {

        fun ViewShot(v: View): Bitmap? {
            val height: Int = v.getHeight()
            val width: Int = v.getWidth()
            val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val c = Canvas(b)
            v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height)
            v.draw(c)
            return b
        }
    }
}