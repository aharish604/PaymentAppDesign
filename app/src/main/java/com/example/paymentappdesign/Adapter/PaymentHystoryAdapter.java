package com.example.paymentappdesign.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentappdesign.Activityes.PaymentHistoryActivity;
import com.example.paymentappdesign.Constants;
import com.example.paymentappdesign.R;
import com.example.paymentappdesign.bean.PaymentHistoryBean;

import java.util.ArrayList;

public class PaymentHystoryAdapter extends RecyclerView.Adapter<PaymentHystoryAdapter.MyViewHolder> {

        Context mcontext;
        ArrayList<PaymentHistoryBean> paymentlist;

    public PaymentHystoryAdapter(PaymentHistoryActivity paymentHistoryActivity, ArrayList<PaymentHistoryBean> paymentlist) {
        this.mcontext = mcontext;
        this.paymentlist = paymentlist;
    }

    @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_item, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            PaymentHistoryBean bean = paymentlist.get(position);
            holder.username_tv.setText(bean.getRecharge_number());
            holder.name_tv.setText(bean.getOperator_name());
            holder.following_tv.setText("" + bean.getStatus());
            holder.followers_tv.setText("" + bean.getTimestamp());


           /* if (bean.getIs_private().equalsIgnoreCase("true")) {
                holder.img_privacy.setImageDrawable(ContextCompat.getDrawable(mcontext, R.drawable.ic_lock));
            } else {
                holder.img_privacy.setImageDrawable(ContextCompat.getDrawable(mcontext, R.drawable.ic_unlock));
            }
*/

            holder.detailsarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constants.displayLongToast(mcontext, "Work in Progress");

                }
            });

        }

        @Override
        public int getItemCount() {
            return paymentlist.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView username_tv, name_tv, followers_tv, following_tv;
            ImageView profile_image, detailsarrow, img_privacy;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                username_tv = itemView.findViewById(R.id.username_tv);
                name_tv = itemView.findViewById(R.id.name_tv);
                followers_tv = itemView.findViewById(R.id.followers_tv);
                following_tv = itemView.findViewById(R.id.following_tv);
                profile_image = itemView.findViewById(R.id.profile_image);
                detailsarrow = itemView.findViewById(R.id.detailsarrow);
              //  img_privacy = itemView.findViewById(R.id.img_privacy);

            }
        }
    }


