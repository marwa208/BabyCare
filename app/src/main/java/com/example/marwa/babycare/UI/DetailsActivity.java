package com.example.marwa.babycare.UI;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.marwa.babycare.R;
import com.squareup.picasso.Picasso;

import io.paperdb.Paper;

public class DetailsActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView imageView;
    TextView nametext;
    TextView destext;
    TextView curetxt;
    TextView prevtext;
    String url;
    String name;
    String desc;
    String cure;
    String prevt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        setContentView(R.layout.activity_details);
        linearLayout = findViewById(R.id.layout);
        imageView = findViewById(R.id.img);
        nametext = findViewById(R.id.name);
        destext = findViewById(R.id.desc);
        curetxt = findViewById(R.id.cure);
        prevtext = findViewById(R.id.prev);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        Picasso.get().load(url).into(imageView);
        name = intent.getStringExtra("name");
        nametext.setText(name);
        desc = intent.getStringExtra("desc");
        destext.setText(desc);
        cure = intent.getStringExtra("cure");
        curetxt.setText(cure);
        prevt = intent.getStringExtra("prev");
        prevtext.setText(prevt);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case (R.id.share):
                startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(this)
                        .setType("text/plain")
                        .setText(url)
                        .getIntent(), "Share"));
                return true;
            case (R.id.save):

                Paper.book().write("desc", desc);
                Paper.book().write("url", url);
                Snackbar snackbar = Snackbar
                        .make(linearLayout, "Saved To Widget", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            case (R.id.home):
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
