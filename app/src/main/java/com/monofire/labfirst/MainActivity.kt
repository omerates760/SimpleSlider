package com.monofire.labfirst

import android.graphics.Movie
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.monofire.labfirst.Adapter.MoviesAdapter
import com.monofire.labfirst.Adapter.SliderPagerAdapter
import com.monofire.labfirst.Model.Movies
import com.monofire.labfirst.Model.Slide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var listPage: ArrayList<Slide>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listPage = ArrayList()
        listPage.add(Slide("Slide page title 1 \n more text here", R.drawable.slide1))
        listPage.add(Slide("Slide page title 2 \n more text here", R.drawable.slide2))
        listPage.add(Slide("Slide page title 3 \n more text here", R.drawable.slide3))
        listPage.add(Slide("Slide page title 4 \n more text here", R.drawable.slide2))
        listPage.add(Slide("Slide page title 5 \n more text here", R.drawable.slide1))

        val adapter: SliderPagerAdapter = SliderPagerAdapter(this@MainActivity, listPage)
        sliderViewPager.adapter = adapter


        indicator.setupWithViewPager(sliderViewPager, true)

        val handler = Handler()
        val update = Runnable {
            if (sliderViewPager.currentItem < listPage.size - 1) {
                sliderViewPager.currentItem = sliderViewPager.currentItem + 1
            } else {
                sliderViewPager.currentItem = 0
            }
            Log.e("SONUC", "GELE")
        }

        Timer().scheduleAtFixedRate(object : TimerTask() {

            override fun run() {
                handler.post(update)

            }
        }, 4000, 6000)


        //Recyclerview setup
        val listMovies= ArrayList<Movies>()
        listMovies.add(Movies("Movie1",R.drawable.movie1))
        listMovies.add(Movies("Movie2",R.drawable.movie2))
        listMovies.add(Movies("Movie3",R.drawable.movie3))
        listMovies.add(Movies("Movie4",R.drawable.movie4))
        listMovies.add(Movies("Movie5",R.drawable.movie5))

        val moviesAdapter=MoviesAdapter(this@MainActivity,listMovies)
        rc_view.adapter=moviesAdapter
        rc_view.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)

    }

}


