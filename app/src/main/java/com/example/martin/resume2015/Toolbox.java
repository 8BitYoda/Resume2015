package com.example.martin.resume2015;

import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class Toolbox extends Fragment {
    private ListView lstView;
    private View rootView;
    List<Tools> tools;

    public static Toolbox newInstance(Context context) {
        Toolbox fragment = new Toolbox();
        return fragment;
    }

    public Toolbox() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_toolbox, container, false);
        lstView =(ListView) rootView.findViewById(R.id.list);
        final FragmentActivity c = getActivity();
        //final RecyclerView recyclerView = (RecyclerView) recView.findViewById(R.id.reView);


        setToolBoxData();
        setToolBoxAdapter();
        return rootView;
    }

    private void setToolBoxAdapter() {
        ListArrayAdapter adapter = new ListArrayAdapter(getActivity(),tools);
        lstView.setAdapter(adapter);
    }

    private void setToolBoxData(){
        tools=new ArrayList<>();
        tools.add(new Header("Languages"));
        tools.add(new ListItem("Android",R.drawable.ic_refresh));
        tools.add(new ListItem("Java",R.drawable.ic_refresh));
        tools.add(new Header("Source Control"));
        tools.add(new ListItem("Git", R.drawable.ic_call));
    }
}
