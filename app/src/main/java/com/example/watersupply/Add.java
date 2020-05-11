package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.watersupply.pack.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Add extends AppCompatActivity {

    EditText text1,text2,text3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        text1=(EditText)findViewById(R.id.txt1);
        text2=(EditText)findViewById(R.id.txt2);
        text3=(EditText)findViewById(R.id.txt3);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.getText().toString().equals("")||text1.getText().toString().equals("")||text3.getText().toString().equals("")){
                    Toast.makeText(Add.this, "please enter the data", Toast.LENGTH_SHORT).show();
                }
                else{
                    doadd(text1.getText().toString(),text2.getText().toString(),text3.getText().toString());
                }

            }
        });

    }
    public void ClearText(){
        text1.setText(null);
        text2.setText(null);
        text3.setText(null);
    }

    private void doadd(final String a_cbottle,final String a_hbottle,final String a_amount )
    {
        Retrofit retrofit = new Retrofit.Builder()
                           .baseUrl(API.url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<String> call = api.add(text1.getText().toString(),text2.getText().toString(),text3.getText().toString());

         call.enqueue(new Callback<String>() {
             @Override
             public void onResponse(Call<String> call, Response<String> response) {
                 btn.setEnabled(true);
                 String data = response.body().toString();
                 Log.e("data1",data);
                 ClearText();
                 if (response.isSuccessful()){
                     Toast.makeText(Add.this, "data inserted", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     Toast.makeText(Add.this, "Error", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<String> call, Throwable t) {
                 Log.e("Host Error"," -"+t.getMessage());
                 Toast.makeText(Add.this, "Request Not Found", Toast.LENGTH_SHORT).show();


             }
         });

    }
}
