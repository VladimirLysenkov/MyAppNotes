package com.example.myappnotes.ui.lists;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;
import com.example.myappnotes.domain.NotesRepositoryImpl;

import java.util.List;


public class NotesListFragment extends Fragment implements NotesListView {

    private LinearLayout container;

    private NotesListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(this, NotesRepositoryImpl.getInstance());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = view.findViewById(R.id.container_list);

        presenter.requestNotes();

    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note : notes) {
            View itemView = getLayoutInflater().inflate(R.layout.item_note, container, false);

            TextView name = itemView.findViewById(R.id.name);
            name.setText(note.getName());

            TextView description = itemView.findViewById(R.id.discription);
            description.setText(note.getDescription());

            TextView updatedAt = itemView.findViewById(R.id.date_updated);
            updatedAt.setText(note.getUpdatedAt());

            container.addView(itemView);

        }

    }
}