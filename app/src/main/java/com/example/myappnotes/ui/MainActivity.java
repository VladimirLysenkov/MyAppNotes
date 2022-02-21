package com.example.myappnotes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.example.myappnotes.R;
import com.example.myappnotes.domain.Note;
import com.example.myappnotes.ui.details.NoteDetailsFragment;
import com.example.myappnotes.ui.lists.NotesListFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavDrawable {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);

        NavigationView navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_notes) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new NotesListFragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                if (item.getItemId() == R.id.action_about) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_list, new Fragment())
                            .commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return false;
            }
        });

        getSupportFragmentManager().setFragmentResultListener(NotesListFragment.NOTE_SELECTED, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                Note note = result.getParcelable(NotesListFragment.SELECTED_NOTE_BUNDLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, NoteDetailsFragment.newInstance(note))
                                .addToBackStack("backstack1")
                                .commitAllowingStateLoss();
                    }
                }, 0L);
            }
        });
    }

    @Override
    public void setAppBar(Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

    }


}