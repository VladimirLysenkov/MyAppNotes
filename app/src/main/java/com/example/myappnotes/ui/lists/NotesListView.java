package com.example.myappnotes.ui.lists;

import com.example.myappnotes.domain.Note;

import java.util.List;

public interface NotesListView {
    void showNotes(List<Note> notes);
}
