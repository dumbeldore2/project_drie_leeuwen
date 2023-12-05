package com.example.project_drie_leeuwen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    //package name
    String packageName = BuildConfig.APPLICATION_ID;

    //intent4 path image
    String imagePath;

    //database initen
    Database database;

    //Edit views initen
    EditText editText,editText2;

    //button initen
    Button button,button1,button2;

    //imageview initen
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //string path
        imagePath = "null";

        //database conecten
        database = new Database(this);

        //views conecten
        //ediottext conecten
        editText = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);

        //buttin conecten
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        //imageview conecten
        imageView = findViewById(R.id.imageview1);

        //functions
        intent4path_fun();
        butt_fun();
        butt1_fun();
        butt2_fun();
    }

    //intent function
    public void intent4path_fun(){
        Intent intent = getIntent();
        if (intent.getStringExtra("path") != null){
            imagePath = intent.getStringExtra("path");
            System.out.println(imagePath);
            if (imagePath.length() > 5){
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                imageView.setImageBitmap(bitmap);
            }
        }
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

    //een button rechtstreeks naar de camera van het aparaat
    public void butt1_fun(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(MainActivity3.this,
                        android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Request the permission
                    int CAMERA_PERMISSION_REQUEST_CODE = 1;
                    ActivityCompat.requestPermissions(MainActivity3.this,
                            new String[]{android.Manifest.permission.CAMERA},
                            CAMERA_PERMISSION_REQUEST_CODE);
                } else {
                    // Permission is already granted, proceed with camera operation
                    dispatchTakePictureIntent();
                }
            }
        });
    }

    public void butt2_fun(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
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

    //chatgpt help
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri imageUri;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Handle error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                imageUri = FileProvider.getUriForFile(this, packageName+".provider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName, ".jpg", storageDir);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // The image has been captured successfully, you can use the imageUri to access the captured image
            // For example, display it in an ImageView
            imageView.setImageURI(imageUri);
        }
    }
}