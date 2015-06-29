package com.example.martin.resume2015;

/**
 * Created by Martin on 6/20/2015.
 */
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.JobViewHolder> {

    public static class JobViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        TextView jobName;
        TextView jobLocation;
        TextView jobDates;
        ImageView jobPhoto;

        JobViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            jobName = (TextView)itemView.findViewById(R.id.job_name);
            jobLocation = (TextView)itemView.findViewById(R.id.job_location);
            jobDates = (TextView) itemView.findViewById(R.id.job_date);
            jobPhoto = (ImageView)itemView.findViewById(R.id.job_photo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){

        }
    }

    List<Job> jobs;

    CardViewAdapter(List<Job> job){
        this.jobs = job;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_experience_item, viewGroup, false);
        JobViewHolder pvh = new JobViewHolder(v);
        //CardView cv = (CardView) pvh.itemView.findViewById(R.id.cv);
//        cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               //stuff here
//            }
//        });
        return pvh;
    }

    @Override
    public void onBindViewHolder(JobViewHolder jobViewHolder, int i) {
        jobViewHolder.jobName.setText(jobs.get(i).title);
        jobViewHolder.jobLocation.setText(jobs.get(i).location);
        jobViewHolder.jobDates.setText(jobs.get(i).dates);
        jobViewHolder.jobPhoto.setImageResource(jobs.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}
