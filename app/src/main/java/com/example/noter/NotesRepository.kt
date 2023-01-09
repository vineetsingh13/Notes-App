package com.example.noter

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao:notesDAO) {

    val allNotes: LiveData<List<note>> = notesDao.getAllNotes()

    suspend fun insert(notes: note){
        notesDao.insert(notes)
    }

    suspend fun delete(notes: note){
        notesDao.delete(notes)
    }

    suspend fun update(notes: note){
        notesDao.update(notes)
    }
}