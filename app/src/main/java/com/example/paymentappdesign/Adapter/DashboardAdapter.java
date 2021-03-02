package com.example.paymentappdesign.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.paymentappdesign.Activityes.MainActivity;
import com.example.paymentappdesign.R;

public class DashboardAdapter extends PagerAdapter {
    String[] names;
    Context mContext;

    public DashboardAdapter(String[] names, MainActivity mainActivity) {
        this.names=names;
        mContext=mainActivity;


    }

    @Override
    public int getCount() {
        return names.length-1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item1, container, false);
        TextView textView=view.findViewById(R.id.name);
        textView.setText(names[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

}
