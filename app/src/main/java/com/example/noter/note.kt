package com.example.noter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class note(
    @ColumnInfo(name = "title")val notesTitle:String,
    @ColumnInfo(name = "description")val notesDescription:String,
    @ColumnInfo(name="timeStamp")val time:String
    ) {
    @PrimaryKey(autoGenerate = true)
    var id=0
}