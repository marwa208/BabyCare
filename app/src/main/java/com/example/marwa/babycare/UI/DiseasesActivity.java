package com.example.marwa.babycare.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.marwa.babycare.Adapters.DiseasesAdapter;
import com.example.marwa.babycare.R;
import com.example.marwa.babycare.model.maindata;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DiseasesActivity extends AppCompatActivity {

    public DatabaseReference mDatabaseReference;
    private ChildEventListener mchChildEventListener;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Data");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<maindata,DiseasesAdapter> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<maindata, DiseasesAdapter>
                (maindata.class, R.layout.layout_list_img, DiseasesAdapter.class, mDatabaseReference) {


            @Override
            protected void populateViewHolder(DiseasesAdapter viewHolder, final maindata model, int position) {
                viewHolder.setDetails(getApplicationContext(),model.getName(),model.getUrl());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),DetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("url",model.getUrl());
                        bundle.putString("name",model.getName());
                        bundle.putString("desc",model.getDescribtion());
                        bundle.putString("cure",model.getCure());
                        bundle.putString("prev",model.getPrevention());
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);

                    }
                });


            }
        };




        //set adapter to recyclerview
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)

        }
            return super.onOptionsItemSelected(item);
        }


    }

