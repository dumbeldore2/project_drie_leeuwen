package com.example.project_drie_leeuwen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;

public class MainActivity4 extends AppCompatActivity {

    //views initen
    ListView listView;

    //adaptter ininten
    MainActivity4_adapter mainActivity4Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //views conencten
        listView = findViewById(R.id.list);

        //alles voor de adapter
        File externalStorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File[] imageFiles = externalStorageDir.listFiles();
        String[] id = externalStorageDir.list();

        //de adapter
        mainActivity4Adapter = new MainActivity4_adapter(this,id,imageFiles);

        //listview aanpassen
        listView.setAdapter(mainActivity4Adapter);

        //functies
        clic_list();
    }

    public void clic_list(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}