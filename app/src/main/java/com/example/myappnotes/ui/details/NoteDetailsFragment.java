package com.example.myappnotes.ui.details;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;


public class NoteDetailsFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static NoteDetailsFragment newInstance(Note note) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);

        NoteDetailsFragment fragment = new NoteDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle arguments = getArguments();

        assert arguments != null;
        Note note = arguments.getParcelable(ARG_NOTE);

        TextView name = view.findViewById(R.id.name);
        name.setText(note.getName());


        TextView dateCreated = view.findViewById(R.id.date_created);
        dateCreated.setText(note.getCreatedAt());

        TextView dateUpdated = view.findViewById(R.id.date_updated);
        dateUpdated.setText(note.getUpdatedAt());

        TextView discription = view.findViewById(R.id.discription);
        discription.setText(note.getDescription());

        TextView noteText = view.findViewById(R.id.note_text);
        noteText.setText(note.getINoteText());


    }

}