package com.example.marwa.babycare.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.marwa.babycare.R;
import com.example.marwa.babycare.UI.DetailsActivity;
import com.example.marwa.babycare.model.maindata;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.security.AccessController.getContext;

public class DiseasesAdapter extends RecyclerView.ViewHolder {

    private View mView;

    public DiseasesAdapter(View itemView) {
        super(itemView);

        mView = itemView;


    }


    public void setDetails(Context context, String name, String url) {

        TextView title_tv = mView.findViewById(R.id.disease_title);
        title_tv.setText(name);

        ImageView home_disease = mView.findViewById(R.id.image);
        Picasso.get().load(url).into(home_disease);
    }


}
