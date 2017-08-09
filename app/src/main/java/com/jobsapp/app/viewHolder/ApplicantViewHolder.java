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

public class ApplicantViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewWork, textViewName, textViewMore;
    public ImageView imageViewApplicant;
    public CardView cardView;


    public ApplicantViewHolder(View v) {
        super(v);
        imageViewApplicant = v.findViewById(R.id.imageViewApplicant);
        textViewWork = v.findViewById(R.id.textViewWork);
        textViewName = v.findViewById(R.id.textViewName);
        textViewMore = v.findViewById(R.id.textViewApplicants);
        cardView = v.findViewById(R.id.cardView);

    }

}
