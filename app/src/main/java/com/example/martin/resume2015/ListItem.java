package com.example.martin.resume2015;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Martin on 6/22/2015.
 */
public class ListItem implements Tools {
    private final String str1;
    private final int pic1;

    public ListItem(String text1, int pic1) {
        this.str1 = text1;
        this.pic1 = pic1;
    }

    @Override
    public int getViewType() {
        return ListArrayAdapter.RowType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.listview_item, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.listText);
        ImageView picture1 = (ImageView) view.findViewById(R.id.listIcon);
        text1.setText(str1);
        picture1.setImageResource(pic1);

        return view;
    }
}
