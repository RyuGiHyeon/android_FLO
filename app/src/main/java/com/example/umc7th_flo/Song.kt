package com.example.umc7th_flo

import androidx.room.PrimaryKey

data class Song(
    val title : String = "",
    val singer : String = "",
    var second : Int = 0,
    var playTime : Int = 0,
    var isPlaying : Boolean = false,
    var music : String = "",
    var coverImg: Int? = null,
    var isLike: Boolean = false
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
