package com.example.paymentappdesign.Activityes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentappdesign.Adapter.ItemsAdapter;
import com.example.paymentappdesign.R;
public class Dasboardadapternew extends RecyclerView.Adapter<Dasboardadapternew.myViewHolder> {

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item4, parent, false);

        myViewHolder myViewHolder = new myViewHolder(view);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

