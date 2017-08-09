package com.jobsapp.app.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.jobsapp.app.ApplicantList;
import com.jobsapp.app.Detail;
import com.jobsapp.app.helper.AppUtils;
import com.jobsapp.app.item.Applicant;
import com.jobsapp.app.item.Job;
import com.jobsapp.app.viewHolder.ApplicantViewHolder;
import com.jobsapp.app.viewHolder.JobViewHolder;

/**
 * Created by Monarchy on 09/08/2017.
 */

public class Configuration {

    public static void setUpJob(JobViewHolder jobViewHolder, Job job, int position, final Activity activity) {
        TextView textViewApplicants = jobViewHolder.textViewApplicants;


        jobViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.navigateUpKeep(activity, Detail.class, null);
            }
        });
        textViewApplicants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUtils.navigateUpKeep(activity, ApplicantList.class, null);
            }
        });
    }

    public static void setUpApplicant(ApplicantViewHolder applicantViewHolder, Applicant applicant, int position, Activity activity) {

    }
}
