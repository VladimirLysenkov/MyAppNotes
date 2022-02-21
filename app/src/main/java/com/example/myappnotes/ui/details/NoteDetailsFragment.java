package com.example.myappnotes.ui.details;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;
import com.example.myappnotes.ui.NavDrawable;


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

        TextView name = view.findViewById(R.id.name_note);
        name.setText(note.getName());

        TextView discription = view.findViewById(R.id.discription);
        discription.setText(note.getDescription());

        TextView dateCreated = view.findViewById(R.id.date_created);
        dateCreated.setText(note.getCreatedAt());

        TextView dateUpdated = view.findViewById(R.id.date_updated);
        dateUpdated.setText(note.getUpdatedAt());

        TextView noteText = view.findViewById(R.id.note_text);
        noteText.setText(note.getNoteText());


        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (requireActivity() instanceof NavDrawable) {
            ((NavDrawable) requireActivity()).setAppBar(toolbar);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_share) {
                    Toast.makeText(requireContext(), "Shared", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });
    }


}