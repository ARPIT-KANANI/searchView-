package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item= menu.findItem(R.id.search);

        SearchView searchview=(SearchView)item.getActionView();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processsearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRcycleOptions<model> options =
        new FirebaseRecycleOptions.Builder<model>()
            .setQuery(FirebaseDatabase.getInstance().getReference().child("students").orderByChild("").startAt(s).endAt(s+""),model.class)
            .build();

        adapter= new adapter(options);
        adapter.startListening();
        recview.setAdapter(adapter)
    }
}