package com.monofire.labfirst.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.monofire.labfirst.Model.Movies
import com.monofire.labfirst.R

class MoviesAdapter(val context:Context,val movieList:ArrayList<Movies>):
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view:View=LayoutInflater.from(context).inflate(R.layout.movies_item,p0,false)


        return MyViewHolder(view)

    }

    override fun getItemCount(): Int=movieList.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        p0.bindItems(movieList[p1])

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title:TextView=view.findViewById(R.id.item_title)
        val image:ImageView=view.findViewById(R.id.item_movie_img)

        fun bindItems(item: Movies) {
            title.text=item.title
            image.setImageResource(item.thumb)

        }

    }
}