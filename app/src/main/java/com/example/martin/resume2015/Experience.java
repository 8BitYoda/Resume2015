package com.example.martin.resume2015;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Experience extends Fragment {
    public List<Job> jobs;
    private RecyclerView recView;
    private View rootView;

    public static Experience newInstance(Context context) {
        Experience fragment = new Experience();
        return fragment;
    }

    public Experience() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity) getActivity()).setActionBarTitle("Experience"); //cahnges title

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_experience, container, false);
        recView =(RecyclerView) rootView.findViewById(R.id.reView);
        final FragmentActivity c = getActivity();
        //final RecyclerView recyclerView = (RecyclerView) recView.findViewById(R.id.reView);


        LinearLayoutManager linLayMan = new LinearLayoutManager(c);
        recView.setLayoutManager(linLayMan);
        recView.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        final GestureDetector mGestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        recView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                int pos = recyclerView.getChildPosition(child);
                String temp = jobs.get(pos).toString();
                Intent intent = new Intent(getActivity(), ExperienceItemActivity.class);
                intent.putExtra("expID", pos);
                intent.putExtra("list", temp);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
            }
            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });

        return rootView;
    }

    private void initializeData(){
        jobs = new ArrayList<>();
        jobs.add(new Job("NetGALAXY Studios", "Charleston, SC", "April 2015 - Current", R.drawable.netgalaxy_logo));
        jobs.add(new Job("LongHorn Steakhouse", "North Charleston, SC", "2014 - Current", R.drawable.longhorn_logo));    }

    private void initializeAdapter(){
        CardViewAdapter adapter = new CardViewAdapter(jobs);
        recView.setAdapter(adapter);
    }
}
