package com.example.project_drie_leeuwen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity2_adapter extends ArrayAdapter<String> {
    Context context;

    //data dat in de list item gaat
    String id [];
    String main [];

    //controller
    public MainActivity2_adapter(@NonNull Context context,
                                 String id [], String main []) {
        super(context, R.layout.activity_main2_list_item,R.id.list,id);
        this.context = context;
        this.id = id;
        this.main = main;
    }

    //view function die de list items gaat toeveogen
    @NonNull
    @Override public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main2_list_item, parent, false);

        TextView textView1 = row.findViewById(R.id.text1);
        TextView textView2 = row.findViewById(R.id.text2);

        textView1.setText(id[position]);
        textView2.setText(main[position]);

        return row;
    }
}