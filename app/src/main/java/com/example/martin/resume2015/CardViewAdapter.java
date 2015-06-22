package com.example.martin.resume2015;

/**
 * Created by Martin on 6/20/2015.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.JobViewHolder> {

    public static class JobViewHolder extends RecyclerView.ViewHolder {

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
        }
    }

    List<Job> jobs;

    CardViewAdapter(List<Job> persons){
        this.jobs = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_experience_item, viewGroup, false);
        JobViewHolder pvh = new JobViewHolder(v);
        CardView cv = (CardView) pvh.itemView.findViewById(R.id.reView);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
