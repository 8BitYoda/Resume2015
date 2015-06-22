package com.example.martin.resume2015;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Martin on 6/22/2015.
 */
public class ListArrayAdapter extends ArrayAdapter<Tools> {
    private LayoutInflater mInflater;

    public enum RowType{ LIST_ITEM, HEADER_ITEM }

    public ListArrayAdapter(Context context, List<Tools> tools){
        super(context, 0, tools);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount(){return RowType.values().length;}

    @Override
    public int getItemViewType(int pos){return getItem(pos).getViewType();}

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    public View getView(int position, View convertView, ViewGroup parent)  {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);
        View View;
        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.listview_item, null);
                    holder.View=getItem(position).getView(mInflater, convertView);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.list_title, null);
                    holder.View=getItem(position).getView(mInflater, convertView);
                    break;
            }
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public static class ViewHolder {
        public  View View;
    }
}
