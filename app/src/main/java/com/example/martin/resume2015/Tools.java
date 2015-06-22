package com.example.martin.resume2015;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Martin on 6/22/2015.
 */
public interface Tools {
    public int getViewType();
    public View getView(LayoutInflater inflater, View convertView);
}
