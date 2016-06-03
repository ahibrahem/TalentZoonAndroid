package com.iti.ahmed.talentzone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 23/05/2016.
 */
public class AdapterClass extends ArrayAdapter<String> {


    private final Context context;
    private final ArrayList<String> header;
    private final ArrayList<String> footer;
    private final ArrayList<Integer> img;

    public AdapterClass(Context context, ArrayList<String> header,ArrayList<String> footer,ArrayList<Integer> img) {
        super(context, R.layout.listviewlayout,header);
        this.context=context;
        this.header=header;
        this.footer=footer;
        this.img=img;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView=convertView;

        // return super.getView(position, convertView, parent);
        LayoutInflater inflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.listviewlayout,parent,false);

        TextView txt1= (TextView)view.findViewById(R.id.textView1);
        TextView txt2= (TextView)view.findViewById(R.id.textView2);
        ImageView im=(ImageView) view.findViewById(R.id.imageView1);

        txt1.setText(header.get(position));
        txt2.setText(footer.get(position));
        im.setImageResource(img.get(position));

        return view;

    }


}

