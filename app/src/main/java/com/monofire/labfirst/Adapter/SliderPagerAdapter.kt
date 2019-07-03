package com.monofire.labfirst.Adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.monofire.labfirst.Model.Slide
import com.monofire.labfirst.R

class SliderPagerAdapter(val ctx:Context,val mList:ArrayList<Slide>): PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean {

        return p0==p1
    }

    override fun getCount(): Int=mList.size



    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater:LayoutInflater= ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val slideLayout:View=inflater.inflate(R.layout.slide_item,container,false)
        val itemTitle:TextView=slideLayout.findViewById(R.id.textView)
        val itemImage:ImageView=slideLayout.findViewById(R.id.imageView2)
        itemTitle.text=mList[position].title
        itemImage.setImageResource(mList[position].Image)
        container.addView(slideLayout)
        return slideLayout
    }
}