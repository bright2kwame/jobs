package com.jobsapp.app.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;


import com.jobsapp.app.R;
import com.jobsapp.app.item.Applicant;
import com.jobsapp.app.item.Job;
import com.jobsapp.app.viewHolder.ApplicantViewHolder;
import com.jobsapp.app.viewHolder.JobViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monarchy on 12/03/15.
 */
public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    private List<Object> items;
    private Activity activity;
    private final int JOBS = 0, APPLICANTS = 1;
    private int lastPosition = -1;
    private List<Object> filterList;
    private ValueFilter valueFilter;


    public BaseAdapter(Activity activity, List<Object> items) {
        this.items = items;
        this.filterList = items;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case JOBS:
                View jobViewHolder = inflater.inflate(R.layout.job_item, viewGroup, false);
                viewHolder = new JobViewHolder(jobViewHolder);
                break;
            case APPLICANTS:
                View applicantViewHolder = inflater.inflate(R.layout.candidate_item, viewGroup, false);
                viewHolder = new ApplicantViewHolder(applicantViewHolder);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case JOBS:
                JobViewHolder jobViewHolder = (JobViewHolder) holder;
                Configuration.setUpJob(jobViewHolder, (Job) items.get(position), position, activity);
                break;
            case APPLICANTS:
                ApplicantViewHolder applicantViewHolder = (ApplicantViewHolder) holder;
                Configuration.setUpApplicant(applicantViewHolder, (Applicant) items.get(position), position, activity);
                break;
        }

        setAnimation(holder.itemView, position);

    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.slide_up);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Job) {
            return JOBS;
        } else if (items.get(position) instanceof Applicant) {
            return APPLICANTS;
        }
        return -1;
    }


    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<Object> newFilterList = new ArrayList<>();
                int arraySize = filterList.size();
                for (int i = 0; i < arraySize; i++) {
                    String searchWord = constraint.toString().toUpperCase();
                    if ((((Job) filterList.get(i)).jobTitle.toUpperCase()).contains(searchWord) || (((Job) filterList.get(i)).jobDecription.toUpperCase()).contains(searchWord)) {
                        Job job = (Job) filterList.get(i);
                        newFilterList.add(job);
                    }
                }
                results.count = newFilterList.size();
                results.values = newFilterList;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            items = (List<Object>) results.values;
            notifyDataSetChanged();
        }

    }
}
