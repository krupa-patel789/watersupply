package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.watersupply.adapter.Adapter;
import com.example.watersupply.modal.ModelClass;
import com.example.watersupply.pack.API;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CustomerDetails extends AppCompatActivity {
    TextInputEditText txtname,adress,phone,cbottle,hbottle,pcbottle,phbottle,credit,
            debit,total,status;
    Button btn;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        String name=getIntent().getStringExtra("name");

        txtname=findViewById(R.id.txtname);
        adress=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        cbottle=findViewById(R.id.cbottle);
        hbottle=findViewById(R.id.hbottle);
        pcbottle=findViewById(R.id.pcbottle);
        phbottle=findViewById(R.id.phbottle);
        credit=findViewById(R.id.credit);
        debit=findViewById(R.id.debit);
        total=findViewById(R.id.total);
        status=findViewById(R.id.status);

        getCustomer(name);


    }
    public void getCustomer(final String name){
        {
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(API.url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            API api = retrofit.create(API.class);
            Call<String> call =api.customerdetails(name);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String a = response.body();
                        Log.e("CUSTOMER",""+a);
                        try {
                            JSONObject jsonObject = new JSONObject(a);
                            if (jsonObject.has("name")) {

                                txtname.setText(jsonObject.getString("name"));
                                adress.setText(jsonObject.getString("address"));
                                phone.setText(jsonObject.getString("mno"));
                                cbottle.setText(jsonObject.getString("c_cbottle"));
                                hbottle.setText(jsonObject.getString("c_hbottle"));
                                pcbottle.setText(jsonObject.getString("c_pcbottle"));
                                phbottle.setText(jsonObject.getString("c_phbottle"));
                                credit.setText(jsonObject.getString("c_credit"));
                                debit.setText(jsonObject.getString("c_debit"));
                                total.setText(jsonObject.getString("c_total"));
                                Toast.makeText(CustomerDetails.this, "hii", Toast.LENGTH_SHORT).show();
                                updateCustomer(txtname.getText().toString(),adress.getText().toString(),phone.getText().toString(),
                                        cbottle.getText().toString(),hbottle.getText().toString(),pcbottle.getText().toString(),
                                        phbottle.getText().toString(),credit.getText().toString(),debit.getText().toString(),
                                        total.getText().toString(),status.getText().toString());


                            } else {
                                Toast.makeText(CustomerDetails.this, "cannot get the data", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                    } else {
                        Log.e("Error", "Server ");
                        Toast.makeText(CustomerDetails.this, "500 Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                    Log.e("Host Error"," -"+t.getMessage());
                    Toast.makeText(CustomerDetails.this, "Request Not Found", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void updateCustomer(final String c_name,final String c_add,final String c_phone, final String c_cbottle
                           ,final String c_hbottle,final String c_pcbottle, final String c_phbottle,
                               final String c_credit,final String c_debit,final String c_total,final String c_status)
    {
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API.url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            API api = retrofit.create(API.class);
            Call<String> call = api.updatecustomer(txtname.getText().toString(),adress.getText().toString(),phone.getText().toString(),
                    cbottle.getText().toString(),hbottle.getText().toString(),pcbottle.getText().toString(),
                    phbottle.getText().toString(),credit.getText().toString(),debit.getText().toString(),
                    total.getText().toString(),status.getText().toString());

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    btn.setEnabled(true);
                    String data = response.body().toString();
                    Log.e("data1",data);
                    if (response.isSuccessful()){
                        Toast.makeText(CustomerDetails.this, "data inserted", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(CustomerDetails.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("Host Error"," -"+t.getMessage());
                    Toast.makeText(CustomerDetails.this, "Request Not Found", Toast.LENGTH_SHORT).show();


                }
            });
        }

    }
}
