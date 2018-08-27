package com.example.pratyush.learningjunction.MyNotes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pratyush.learningjunction.R;

//this class holds all our views and they all will be recycled. Here we can also implement Views.onItemClick Listener
public class MyHolder extends RecyclerView.ViewHolder {

    TextView titletxt, descriptiontxt;

    public MyHolder(View itemView) {
        super(itemView);
        titletxt=itemView.findViewById(R.id.cardtitle);
        descriptiontxt=itemView.findViewById(R.id.carddescription);
    }

}
