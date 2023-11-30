package com.example.project_drie_leeuwen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //init database
    Database database;

    //initen van de listview
    MainActivity2_adapter mainActivity2Adapter;

    //init de layouts
    Button button, button2;
    ListView listView;
    TextView textView;

    //string voor het verschil tussen user en admin deftig te communiceren
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //conect database
        database = new Database(this);

        //conect layouts
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        listView = findViewById(R.id.list);
        textView = findViewById(R.id.text1);

        //conecten van de adapter
        mainActivity2Adapter =new MainActivity2_adapter(MainActivity2.this, database.t1c0(),
                database.t1c1());
        //listview ook aanpassen hier
        listView.setAdapter(mainActivity2Adapter);

        //intent
        Intent intent = getIntent();
        //test - System.out.println(intent.getStringExtra("mode"));
        mode = intent.getStringExtra("mode");

        //functions
        //test - System.out.println(mode);
        check_mode(mode);
        add_item_button();

    }

    public void check_mode(String mode){
        if(mode.equals("admin")){
            textView.setText("admin mode");
            textView.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
        }
    }

    //add item button function
    public void add_item_button(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this ,MainActivity3.class);
                startActivity(intent);
            }
        });
    }

}