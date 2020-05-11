package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.InputType;
import android.app.DatePickerDialog;
import com.example.watersupply.pack.API;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class plus extends AppCompatActivity {
    DatePickerDialog datePicker;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

       
        text1=(EditText)findViewById(R.id.txt1);
        text2=(EditText)findViewById(R.id.txt2);
        text3=(EditText)findViewById(R.id.txt3);
        text4=(EditText)findViewById(R.id.txt4);
        text5=(EditText)findViewById(R.id.txt5);
        text6=(EditText)findViewById(R.id.txt6);
        text7=(EditText)findViewById(R.id.txt7);
        text8=(EditText)findViewById(R.id.txt8);
        text9=(EditText)findViewById(R.id.txt9);
        text10=(EditText)findViewById(R.id.txt10);
        text11=(EditText)findViewById(R.id.txt11);
        text12=(EditText)findViewById(R.id.txt12);
        text13=(EditText)findViewById(R.id.txt13);
        text14=(EditText)findViewById(R.id.txt14);
        btn=(Button) findViewById(R.id.button);
        text4.setInputType(InputType.TYPE_NULL);




        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(plus.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        text4.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                },year,month,day);

                datePicker.show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.getText().toString().equals("")||text2.getText().toString().equals("")||text3.getText().toString().equals("")||
                        text4.getText().toString().equals("")||text5.getText().toString().equals("")||text6.getText().toString().equals("")||
                        text7.getText().toString().equals("")||text8.getText().toString().equals("")||text9.getText().toString().equals("")||
                        text10.getText().toString().equals("")||text11.getText().toString().equals("")||text12.getText().toString().equals("")||
                        text13.getText().toString().equals("")||text14.getText().toString().equals(""))
                {

                    Toast.makeText(plus.this, "please enter the data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  doaddinsert(text1.getText().toString(),text2.getText().toString(),text3.getText().toString(),text4.getText().toString(),
                          text5.getText().toString(),text6.getText().toString(),text7.getText().toString(),text8.getText().toString(),
                          text9.getText().toString(),text10.getText().toString(),text11.getText().toString(),text12.getText().toString(),
                          text13.getText().toString(),text14.getText().toString());
                }

            }
        });


    }
    public void ClearText(){
        text1.setText(null);
        text2.setText(null);
        text3.setText(null);
        text4.setText(null);
        text5.setText(null);
        text6.setText(null);
        text7.setText(null);
        text8.setText(null);
        text9.setText(null);
        text10.setText(null);
        text11.setText(null);
        text12.setText(null);
        text13.setText(null);
        text14.setText(null);

    }

    public void doaddinsert(final String c_name,final String c_add,final String c_phone,final String c_date,
                            final String c_cbottle,final String c_hbottle,final String c_pcbottle,
                            final String c_phbottle,final String c_rcbottle,final String c_rhbottle,
                            final String c_credit,final String c_debit,final String c_total,final String c_status)
               {
                   Retrofit retrofit = new Retrofit.Builder()
                           .baseUrl(API.url)
                           .addConverterFactory(ScalarsConverterFactory.create())
                           .build();
                   API api = retrofit.create(API.class);
                   Call<String> call = api.insert(text1.getText().toString(),text2.getText().toString(),
                           text3.getText().toString(),text4.getText().toString(),text5.getText().toString(),
                           text6.getText().toString(),text7.getText().toString(),text8.getText().toString(),
                           text9.getText().toString(),text10.getText().toString(),text11.getText().toString(),
                           text12.getText().toString(),text13.getText().toString(),text14.getText().toString());

                   call.enqueue(new Callback<String>() {
                       @Override
                       public void onResponse(Call<String> call, Response<String> response) {

                           btn.setEnabled(true);
                           String data = response.body().toString();
                           Log.e("data1",data);
                           ClearText();
                           if (response.isSuccessful()){
                               Toast.makeText(plus.this, "data inserted", Toast.LENGTH_SHORT).show();

                           }
                           else {
                               Toast.makeText(plus.this, "Error", Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onFailure(Call<String> call, Throwable t) {
                           Log.e("Host Error"," -"+t.getMessage());
                           Toast.makeText(plus.this, "Request Not Found", Toast.LENGTH_SHORT).show();


                       }
                   });
               }
}
