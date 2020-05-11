package com.example.watersupply;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import com.example.watersupply.pack.retrofit;
import com.example.watersupply.pack.API;
import com.example.watersupply.pack.apiutils;
import com.example.watersupply.pack.resobj;

public class MainActivity extends AppCompatActivity {

    EditText t1, t2;
    Button button;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        t1 = (EditText) findViewById(R.id.text1);
        t2 = (EditText) findViewById(R.id.text2);
        api=apiutils.getUserService();

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1.getText().toString().equals("")||t2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please enter the data", Toast.LENGTH_SHORT).show();
                }
                else{
                    doLogin(t1.getText().toString(),t2.getText().toString());
                }

            }
        });

    }


    private void doLogin(final String r_email,final String r_pwd){
        Retrofit retrofit=new Retrofit.Builder()
                  .baseUrl(API.url).addConverterFactory(ScalarsConverterFactory.create()).build();
        API api = retrofit.create(API.class);
        Log.e("urlshow",API.url);
        Call<String> call =api.checkLogin(r_email,r_pwd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String a = response.body().toString();
                    Log.e("data1", a);

                    try {
                        JSONObject jsonObject = new JSONObject(a);
                        if (jsonObject.has("r_email")) {
                            Toast.makeText(MainActivity.this, "login succese", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(MainActivity.this, "Invalid user name or pass", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.e("Error", "Server ");
                    Toast.makeText(MainActivity.this, "500 Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                    Log.e("Host Error"," -"+t.getMessage());
                    Toast.makeText(MainActivity.this, "Request Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
