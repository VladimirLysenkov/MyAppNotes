package com.example.myappnotes.ui.lists;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;
import com.example.myappnotes.domain.NotesRepositoryImpl;
import com.example.myappnotes.ui.NavDrawable;
import com.example.myappnotes.ui.details.NoteDetailsActivity;

import java.util.List;


public class NotesListFragment extends Fragment implements NotesListView {

    public static final String NOTE_SELECTED = "NOTE_SELECTED";
    public static final String SELECTED_NOTE_BUNDLE = "SELECTED_NOTE_BUNDLE";

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

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (requireActivity() instanceof NavDrawable) {
            ((NavDrawable) requireActivity()).setAppBar(toolbar);
        }

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_add) {
                    Toast.makeText(requireContext(), "????????????????", Toast.LENGTH_SHORT).show();
                    return true;
                }

                if (item.getItemId() == R.id.action_search) {
                    Toast.makeText(requireContext(), "??????????", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });

        container = view.findViewById(R.id.container_list);

        presenter.requestNotes();

    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note : notes) {
            View itemView = getLayoutInflater().inflate(R.layout.item_note, container, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(SELECTED_NOTE_BUNDLE, note);

                    getParentFragmentManager()
                            .setFragmentResult(NOTE_SELECTED, bundle);
                }


            });

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