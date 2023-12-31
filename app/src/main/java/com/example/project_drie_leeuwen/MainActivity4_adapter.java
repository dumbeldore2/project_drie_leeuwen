package com.example.project_drie_leeuwen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.io.File;

public class MainActivity4_adapter extends ArrayAdapter<String> {
    Context context;
    //data in list
    String id [];
    File images [];
    public MainActivity4_adapter(@NonNull Context context, String id [],
                                 File images []) {
        super(context, R.layout.activity_main4_list_item, R.id.list, id);
        this.context = context;
        this.images = images;
        this.id = id;
    }

    //vieuw function die de list items gaat toevoegen
    @NonNull
    @Override public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main4_list_item, parent, false);

        TextView textView1 = row.findViewById(R.id.text1);
        ImageView imageView = row.findViewById(R.id.imageview1);

        Bitmap bitmap = BitmapFactory.decodeFile(images[position].getAbsolutePath());
        textView1.setText(id[position]);
        imageView.setImageBitmap(bitmap);
        imageView.setRotation(90f);

        return row;
    }
}