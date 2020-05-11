package com.example.watersupply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.watersupply.adapter.Adapter;
import com.example.watersupply.modal.ModelClass;
import com.example.watersupply.pack.API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class recyclerview extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView=(RecyclerView)findViewById(R.id.rview);
        recyclerView.setNestedScrollingEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        getUserDetail();
    }

    public  void getUserDetail(){

        Retrofit retrofit = new Retrofit.Builder()
                           .baseUrl(API.url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
     API api = retrofit.create(API.class);

        Call<String> call =api.customer();
      call.enqueue(new Callback<String>() {
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
      if (response.isSuccessful()){
          String a = response.body().toString();
     try{

        JSONArray object = new JSONArray(a);
        Log.e("data url",object.toString());
        List<ModelClass> list = new ArrayList<>();
        for (int i=0;i<object.length();i++){
            Log.e("data for loop",object.toString(i));
            ModelClass modelClass = new ModelClass(object.getString(i));
            list.add(modelClass);
        }

        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);

    }
     catch (Exception e) {
         Log.e("Json Error","" + e.getMessage());
         Toast.makeText(recyclerview.this, "Json Error", Toast.LENGTH_SHORT).show();

     }
}
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Log.e("Host Error"," -"+t.getMessage());
        Toast.makeText(recyclerview.this, "Request Not Found", Toast.LENGTH_SHORT).show();


    }
});
    }
}
