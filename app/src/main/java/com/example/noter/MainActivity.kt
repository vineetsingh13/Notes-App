package com.example.noter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NoteClickDeleteInterface, NoteClickInterface {

    lateinit var viewModel: notesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val staggered = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recycler_view.layoutManager=LinearLayoutManager(this)

        val notesRVadapter= NotesRVadapter(this,this,this)
        recycler_view.adapter=notesRVadapter
        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(notesViewModel::class.java)

        viewModel.allNotes.observe(this,{list->
            list?.let {
                notesRVadapter.updateList(it)
            }
        })


        fab.setOnClickListener{
            val intent=Intent(this@MainActivity,create_note::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onDeleteIconClick(note: note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.notesTitle} deleted",Toast.LENGTH_SHORT).show()
    }

    override fun onNoteClick(note: note) {
        val intent = Intent(this@MainActivity, create_note::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", note.notesTitle)
        intent.putExtra("noteDescription", note.notesDescription)
        intent.putExtra("noteId", note.id)
        startActivity(intent)
        this.finish()
    }
}