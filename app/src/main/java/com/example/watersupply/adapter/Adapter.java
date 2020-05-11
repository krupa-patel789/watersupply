package com.example.watersupply.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watersupply.CustomerDetails;
import com.example.watersupply.R;
import com.example.watersupply.modal.ModelClass;
import com.example.watersupply.pack.API;

import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.AdapterView>
{
private List<ModelClass> modelClassList;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rview,parent,false);
      return new Adapter.AdapterView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView holder, int position) {
        ModelClass modelClass = modelClassList.get(position);

        holder.textView.setText(modelClass.getName());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.v.getContext(),CustomerDetails.class);
                intent.putExtra("name",modelClass.getName());
                holder.v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
    return modelClassList.size();
    }

    public class AdapterView extends RecyclerView.ViewHolder {
        TextView textView;
        View v;

        public AdapterView(@NonNull View itemView) {
            super(itemView);
            v=itemView;
            textView = itemView.findViewById(R.id.txt);
        }
    }
}

