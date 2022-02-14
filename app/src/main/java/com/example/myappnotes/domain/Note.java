package com.example.myappnotes.domain;


public class Note {
    private final int id;
    private final String name;
    private final String description;
    private final String createdAt;
    private final String updatedAt;
    private final String noteText;


    public Note(int id, String name, String description, String createdAt, String updatedAt, String noteText) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.noteText = noteText;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getINoteText() {
        return noteText;
    }
}