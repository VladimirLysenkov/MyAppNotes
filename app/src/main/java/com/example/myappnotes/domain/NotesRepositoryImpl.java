package com.example.myappnotes.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {

    private static final NotesRepository INSTANCE = new NotesRepositoryImpl();

    public static NotesRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(UUID.randomUUID().hashCode(), "Заметка №1", "Описание заметки №1", "09.02.2022", "10.02.2022", "Текст заметки №1"));
        notes.add(new Note(UUID.randomUUID().hashCode(), "Заметка №2", "Описание заметки №2", "04.02.2022", "09.02.2022", "Текст заметки №2"));
        notes.add(new Note(UUID.randomUUID().hashCode(), "Заметка №3", "Описание заметки №3", "22.12.2021", "01.02.2022", "Текст заметки №3"));

        return notes;
    }
}
