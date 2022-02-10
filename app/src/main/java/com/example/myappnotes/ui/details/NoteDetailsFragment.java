package com.example.myappnotes.ui.details;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myappnotes.R;


public class NoteDetailsFragment extends Fragment {

    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name = view.findViewById(R.id.name_note);
        TextView dateCreated = view.findViewById(R.id.date_created);
        TextView dateUpdated = view.findViewById(R.id.date_updated);
        TextView discription = view.findViewById(R.id.discription);
        TextView noteText = view.findViewById(R.id.note_text);

    }
}