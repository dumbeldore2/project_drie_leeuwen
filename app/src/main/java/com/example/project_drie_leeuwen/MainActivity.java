package com.example.project_drie_leeuwen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //init variabelen
    TextView textView1,textView2;//textviews
    String mode;//mode voor user en admin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //varibelen initen
        textView1 = findViewById(R.id.text1);//user textview
        textView2 = findViewById(R.id.text2);//admin textview
        mode = "User";

        //functies
        clic_fun1();
        clic_fun2();
    }
    //gaat naar mainactivty2 in de user mode
    public void clic_fun1(){
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    //gaat naar mainactivty2 in de admin mode
    public void clic_fun2(){
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    //change mode to admin
    public void changeToAdmin(){
        mode = "Admin";
    }
}