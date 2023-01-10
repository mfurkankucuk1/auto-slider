package com.mfk.autoslider

/**
 * Created by M.Furkan KÜÇÜK on 10.01.2023
 **/
import android.content.Context
import android.os.Handler
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class AutoIndicatorSlider : ViewPager {
    private var currentPage = 0
    private var autoSlide: Boolean = false
    private var slideInterval = 1500

    @get:JvmName("getHandler()")
    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var indicatorContainer: LinearLayout? = null
    private var indicators: MutableList<TextView> = mutableListOf()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    fun startAutoSlide() {
        autoSlide = true
        handler = Handler()
        runnable = Runnable {
            if (currentPage == adapter!!.count) {
                currentPage = 0
            }
            this@AutoIndicatorSlider.setCurrentItem(currentPage++, true)
            if (autoSlide) {
                handler!!.postDelayed(runnable!!, slideInterval.toLong())
            }
        }
        handler!!.postDelayed(runnable!!, slideInterval.toLong())
    }

    fun stopAutoSlide() {
        autoSlide = false
    }

    fun setSlideInterval(interval: Int) {
        slideInterval = interval
    }

    fun setIndicatorContainer(container: LinearLayout) {
        indicatorContainer = container
    }

    fun setUpIndicator() {
        indicatorContainer!!.removeAllViews()
        indicators.clear()
        for (i in 0 until adapter!!.count) {
            val indicator = TextView(context)
            indicator.text = "•"
            indicator.textSize = 30f
            indicator.setPadding(5, 0, 5, 0)
            indicators.add(indicator)
            indicatorContainer!!.addView(indicator)
        }
        indicators[currentPage].setTextColor(resources.getColor(android.R.color.darker_gray))
    }

    fun setIndicatorColor(color: Int) {
        for (indicator in indicators) {
            indicator.setTextColor(color)
        }
    }

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        super.setCurrentItem(item, smoothScroll)
    }
}
