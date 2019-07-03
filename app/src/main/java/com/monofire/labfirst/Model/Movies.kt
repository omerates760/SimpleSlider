package com.monofire.labfirst.Model

data class Movies(val title: String, val thumb: Int){
    constructor( title:String, description:String, thumb:Int, studio:String, rating:String, streamLink:String):this(title,thumb){

    }
}
