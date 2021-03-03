package com.example.paymentappdesign.Activityes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import com.example.paymentappdesign.Adapter.DashboardAdapter;
import com.example.paymentappdesign.Adapter.ItemsAdapter;
import com.example.paymentappdesign.R;

public class MainActivity extends AppCompatActivity {

    String names[]={"Harish","Harish","Harish","Harish","Harish","Harish","Harish"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.mainlayout);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.BLUE));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.BLUE));



    /*   DashboardAdapter adapter = new DashboardAdapter(names, MainActivity.this);
        ViewPager viewPager=findViewById(R.id.recycer_View);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50, 10, 50, 10);

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

*/

    RecyclerView mRecyclerView=findViewById(R.id.recycer_View);
    RecyclerView recycer_View2=findViewById(R.id.recycer_View2);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        mRecyclerView.setAdapter(new ItemsAdapter());



        recycer_View2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recycer_View2.setAdapter(new Dasboardadapternew());




        ImageButton btn=findViewById(R.id.logOutB);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this, PaymentHistoryActivity.class));
            }
        });
    }
}