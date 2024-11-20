package com.example.umc7th_flo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.ArrayList

@Entity(tableName = "AlbumTable")
data class Album(
    @PrimaryKey(autoGenerate = false) var id: Int = 0,
    var title : String? = "",
    var singer : String? = "",
    var coverImg : Int? = null,
)
