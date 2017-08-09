package com.jobsapp.app.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jobsapp.app.R;


/**
 * Created by Monarchy on 03/12/2016.
 */

public class JobViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewName, textViewMore, textViewApplicants;
    public ImageView imageView;
    public CardView cardView;
    public Button buttonApply;


    public JobViewHolder(View v) {
        super(v);
        imageView = v.findViewById(R.id.imageView);
        textViewName = v.findViewById(R.id.textViewName);
        textViewMore = v.findViewById(R.id.textViewMore);
        textViewApplicants = v.findViewById(R.id.textViewApplicants);
        buttonApply = v.findViewById(R.id.buttonApply);
        cardView = v.findViewById(R.id.cardView);

    }

}
