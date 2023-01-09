package com.example.noter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class notesViewModel(application: Application) : AndroidViewModel(application) {

    var respository: NotesRepository
    val allNotes: LiveData<List<note>>


    init {
        val dao=notesDatabase.getDatabase(application).getNoteDao()
        respository=NotesRepository(dao)
        allNotes=respository.allNotes
    }

    fun deleteNote(notes: note)=viewModelScope.launch(Dispatchers.IO) {
        respository.delete(notes)

    }

    fun insertNote(notes: note)=viewModelScope.launch(Dispatchers.IO) {
        respository.insert(notes)
    }

    fun updateNote(notes: note)=viewModelScope.launch(Dispatchers.IO) {
        respository.update(notes)

    }
}