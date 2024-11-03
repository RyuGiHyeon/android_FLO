package com.example.umc7th_flo

import java.util.ArrayList

data class Album(
    var title : String? = "",
    var singer : String? = "",
    var coverImg : Int? = null,
    var songs : ArrayList<Song>? = null
)
