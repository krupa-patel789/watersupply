package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class cardview extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5,img6;
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        text1=(TextView) findViewById(R.id.txt1);
        text2=(TextView) findViewById(R.id.txt3);
        img1= (ImageView)findViewById(R.id.img1);
        img2= (ImageView)findViewById(R.id.img2);
        img3= (ImageView)findViewById(R.id.img3);
        img4= (ImageView)findViewById(R.id.img4);
        img5= (ImageView)findViewById(R.id.img5);
        img6= (ImageView)findViewById(R.id.img6);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,Add.class);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,plus.class);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,recyclerview.class);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,Add.class);
                startActivity(intent);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,Add.class);
                startActivity(intent);
                finish();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardview.this,Add.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
