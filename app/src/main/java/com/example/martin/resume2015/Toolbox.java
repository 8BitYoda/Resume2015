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
        ((MainActivity) getActivity()).setActionBarTitle("Technical Toolbox");
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
        tools.add(new ListItem("Android",R.drawable.ic_android));
        tools.add(new ListItem("Java",R.drawable.ic_java));
        tools.add(new ListItem("C++", R.drawable.ic_cpp));
        tools.add(new ListItem("XML", R.drawable.ic_xml));
        tools.add(new ListItem("Visual Basic", R.drawable.ic_vb));
        tools.add(new ListItem("JavaScript", R.drawable.ic_javascript));
        tools.add(new ListItem("HTML", R.drawable.ic_html));
        tools.add(new ListItem("CSS", R.drawable.ic_css));
        tools.add(new Header("Source Control"));
        tools.add(new ListItem("Git", R.drawable.ic_git));
        tools.add(new ListItem("GitHub", R.drawable.ic_github_cat));
        tools.add(new ListItem("SourceTree", R.drawable.ic_sourcetree));
        tools.add(new ListItem("BitBucket", R.drawable.ic_bitbucket));
        tools.add(new Header("DataBase"));
        tools.add(new ListItem("Parse", R.drawable.ic_parse));
        tools.add(new ListItem("MS Access", R.drawable.ic_access));
        tools.add(new ListItem("SQL", R.drawable.ic_sql));
        tools.add(new Header("Design & IDE Tools"));
        tools.add(new ListItem("Android Studio", R.drawable.ic_androidstudio));
        tools.add(new ListItem("Visual Studio", R.drawable.ic_visual_studio));
        tools.add(new ListItem("Genymotion", R.drawable.ic_genymotion));
        tools.add(new ListItem("Ionic", R.drawable.ic_ionic));
        tools.add(new Header("Office Tools"));
        tools.add(new ListItem("MS Project", R.drawable.ic_project));
        tools.add(new ListItem("MS Visio", R.drawable.ic_visio));
        tools.add(new ListItem("MS Excel", R.drawable.ic_excel));
        tools.add(new ListItem("MS Word", R.drawable.ic_word));
    }
}
