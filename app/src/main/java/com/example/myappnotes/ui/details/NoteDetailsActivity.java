package com.example.myappnotes.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_NOTE = "EXTRA_NOTE";

    public static void show(Context context, Note note) {
        Intent intent = new Intent(context, NoteDetailsActivity.class);
        intent.putExtra(EXTRA_NOTE, note);

        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_note_details);

        if (savedInstanceState == null) {
            Note note = getIntent().getParcelableExtra(EXTRA_NOTE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, NoteDetailsFragment.newInstance(note))
                    .commit();
        }
    }
}