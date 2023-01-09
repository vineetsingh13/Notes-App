package com.example.noter

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface notesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: note)

    @Delete
    suspend fun delete(notes: note)

    @Update
    suspend fun update(notes: note)

    @Query(value = "Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<note>>
}