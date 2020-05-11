package com.example.watersupply.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.watersupply.CustomerDetails;
import com.example.watersupply.R;
import com.example.watersupply.modal.ModelCustomer;

import java.util.List;

public class AdapterCustomer extends RecyclerView.Adapter<AdapterCustomer.AdapterView>{
    private List<ModelCustomer> modelCustomerList;

    public AdapterCustomer(List<ModelCustomer> modelCustomerList) {
        this.modelCustomerList = modelCustomerList;
    }

    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_customer_details,parent,false);
        return new AdapterCustomer.AdapterView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView holder, int position) {
        ModelCustomer modelCustomer = modelCustomerList.get(position);
        holder.edt1.setText(modelCustomer.getName());
        holder.edt2.setText(modelCustomer.getAddress());
        holder.edt10.setText(modelCustomer.getPhoneno());
        holder.edt3.setText(modelCustomer.getCbottle());
        holder.edt4.setText(modelCustomer.getHbottle());
        holder.edt5.setText(modelCustomer.getPcbottle());
        holder.edt6.setText(modelCustomer.getPhbottle());
        holder.edt7.setText(modelCustomer.getCredit());
        holder.edt8.setText(modelCustomer.getDebit());
        holder.edt9.setText(modelCustomer.getTotal());



    }

    @Override
    public int getItemCount() {
        return modelCustomerList.size();
    }

    public class AdapterView extends RecyclerView.ViewHolder{
    EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10;

    public AdapterView(@NonNull View itemView) {
        super(itemView);
        edt1 = itemView.findViewById(R.id.txt1);
        edt2 = itemView.findViewById(R.id.txt2);
        edt3 = itemView.findViewById(R.id.txt3);
        edt4 = itemView.findViewById(R.id.txt5);
        edt5 = itemView.findViewById(R.id.txt6);
        edt6 = itemView.findViewById(R.id.txt7);
        edt7 = itemView.findViewById(R.id.txt8);
        edt8 = itemView.findViewById(R.id.txt10);
        edt9 = itemView.findViewById(R.id.txt11);
        edt10 = itemView.findViewById(R.id.txt12);
    }
}


}
