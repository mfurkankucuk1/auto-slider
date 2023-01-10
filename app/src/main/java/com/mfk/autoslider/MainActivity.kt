package com.mfk.autoslider

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf<String>(
            "https://picsum.photos/id/237/200/300",
            "https://picsum.photos/id/200/200/300",
            "https://picsum.photos/id/231/200/300",
            "https://picsum.photos/id/232/200/300",
            "https://picsum.photos/id/233/200/300"
        )
        val viewPager = findViewById<AutoIndicatorSlider>(R.id.vp)
        val dots = findViewById<LinearLayout>(R.id.ll)
        viewPager.adapter = AutoSliderAdapter(this, imageList)
        viewPager.startAutoSlide()
        viewPager.setIndicatorContainer(dots)
        viewPager.setIndicatorColor(ContextCompat.getColor(this,R.color.black))
        viewPager.setUpIndicator()





    }
}