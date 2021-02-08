package com.polotech.starwars.data.remote.util

fun String.addHttps() : String {
    var string = ""
    string = if(this.contains("https")){
        this
    }else{
        this.replace("http", "https")
    }
    return string

}