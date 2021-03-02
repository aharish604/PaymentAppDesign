package com.example.paymentappdesign.Interface;

import com.example.paymentappdesign.bean.PaymentHistoryBean;

import java.util.ArrayList;

public interface PaymentViews {

    void showProgressDialog();
    void hideProgressDialog();
    void displayData(ArrayList<PaymentHistoryBean> list);
}
