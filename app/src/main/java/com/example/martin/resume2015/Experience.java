package com.example.martin.resume2015;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Experience extends Fragment {
    private List<Job> jobs;
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
