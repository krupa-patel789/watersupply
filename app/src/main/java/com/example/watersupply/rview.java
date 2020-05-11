package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watersupply.adapter.AdapterCustomer;
import com.example.watersupply.modal.ModelCustomer;
import com.example.watersupply.pack.API;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class rview extends AppCompatActivity {
LinearLayout linearLayout;
RecyclerView recyclerView;
TextView textView;
AdapterCustomer adapterCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rview);

        linearLayout=(LinearLayout)findViewById(R.id.L2);
        textView=(TextView)findViewById(R.id.txt);
        recyclerView=(RecyclerView)findViewById(R.id.rview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Toast.makeText(rview.this, "hiii", Toast.LENGTH_SHORT).show();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(rview.this, "check click", Toast.LENGTH_SHORT).show();


            }
        });
    }
   /* public void customer(final String c_name){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(API.url).addConverterFactory(ScalarsConverterFactory.create()).build();
        API api = retrofit.create(API.class);
        Log.e("urlshow",API.url);
        Call<String> call =api.customerdetails();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String a = response.body().toString();
                    Log.e("data1", a);

                    try {
                        JSONObject jsonObject = new JSONObject(a);
                        if (jsonObject.has("c_name")) {
                            JSONArray data = jsonObject.getJSONArray("data");
                            Gson gson = new Gson();
                            Type  type = new TypeToken<List<ModelCustomer>>(){}.getType();
                            List<ModelCustomer> modelCustomers = gson.fromJson(data.toString(),type);
                            adapterCustomer = new AdapterCustomer(modelCustomers);
                            recyclerView.setAdapter(adapterCustomer);


                        } else {
                            Toast.makeText(rview.this, "can not find data", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        Log.e("Json Error",""+e.getMessage());
                        Toast.makeText(rview.this, "Json Error", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.e("Error", "Server ");
                    Toast.makeText(rview.this, "500 Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }*/
}
