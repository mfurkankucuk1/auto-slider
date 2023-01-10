package com.mfk.autoslider

/**
 * Created by M.Furkan KÜÇÜK on 10.01.2023
 **/
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class AutoSliderAdapter(val context: Context, val images: List<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.image_slider_item, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        Glide.with(this.context)
            .load(images[position])
            .circleCrop()
            .into(imageView)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
