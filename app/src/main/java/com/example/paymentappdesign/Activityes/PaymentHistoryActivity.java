package com.example.paymentappdesign.Activityes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.paymentappdesign.Constants;
import com.example.paymentappdesign.Interface.PaymentViews;
import com.example.paymentappdesign.bean.PaymentHistoryBean;
import com.example.paymentappdesign.Adapter.PaymentHystoryAdapter;
import com.example.paymentappdesign.presenter.PaymentPresenter;
import com.example.paymentappdesign.R;

import java.util.ArrayList;

public class PaymentHistoryActivity extends AppCompatActivity implements PaymentViews {

    ProgressDialog progressDialog = null;
    RecyclerView payment_rv=null;
    TextView norecordsfound_tv=null;
    ArrayList<PaymentHistoryBean> paymentlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        InitUi();
        IntializeObjects();
    }
    private void InitUi() {
        payment_rv=findViewById(R.id.payment_rv);
        norecordsfound_tv=findViewById(R.id.norecorsfound_tv);

    }

    private void IntializeObjects() {

        PaymentPresenter presenter=new PaymentPresenter(PaymentHistoryActivity.this,PaymentHistoryActivity.this);
        presenter.getData();
    }
    private void InitRecycelrView() {
        payment_rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        payment_rv.setAdapter(new PaymentHystoryAdapter(PaymentHistoryActivity.this,paymentlist));
    }







    @Override
    public void showProgressDialog() {
        progressDialog = Constants.showProgressDialog(PaymentHistoryActivity.this, "");

    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void displayData(ArrayList<PaymentHistoryBean> list) {

        Constants.displayLongToast(PaymentHistoryActivity.this,""+list.size());
        paymentlist=list;
        InitRecycelrView();


    }
}