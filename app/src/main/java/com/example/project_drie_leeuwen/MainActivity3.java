package com.example.project_drie_leeuwen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    //database initen
    Database database;

    //Edit views initen
    EditText editText,editText2;

    //button initen
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //database conecten
        database = new Database(this);

        //views conecten
        //ediottext conecten
        editText = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);

        //buttin conecten
        button = findViewById(R.id.button);

        //functions
        butt_fun();
    }

    //function add to database
    public void add_to_database(String main, String second){
        database.addToTable1(main,second);
    }

    //button function
    public void butt_fun(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                add_to_database(get_from_editText1(), get_from_editText2());
                intent.putExtra("mode","admin");
                startActivity(intent);
            }
        });
    }

    //edit text 1 fun
    public String get_from_editText1() {
        String out = "";
        out += editText.getText();
        return out;
    }

    //edit text 2 fun
    public String get_from_editText2(){
        String out = "";
        out += editText2.getText();
        return out;
    }
}