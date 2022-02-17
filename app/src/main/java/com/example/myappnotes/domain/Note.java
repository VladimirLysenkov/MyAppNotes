package com.example.myappnotes.domain;


import android.os.Parcel;
import android.os.Parcelable;


public class Note implements Parcelable {
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


    protected Note(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        noteText = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(id));
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(noteText);

    }
}