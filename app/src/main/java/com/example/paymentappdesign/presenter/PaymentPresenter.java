package com.example.paymentappdesign.presenter;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.paymentappdesign.Constants;
import com.example.paymentappdesign.Interface.AppController;
import com.example.paymentappdesign.Interface.PaymentViews;
import com.example.paymentappdesign.bean.PaymentHistoryBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PaymentPresenter {

    PaymentViews mView;
    Context mContext;
    ArrayList<PaymentHistoryBean> list = new ArrayList<>();
    public PaymentPresenter(Context context, PaymentViews paymentViews) {
        mView = paymentViews;
        mContext = context;
    }

    public void getData() {


        ((Activity) mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    mView.showProgressDialog();
                }

            }
        });


        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, Constants.APIKEY, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                list.clear();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = response.getJSONObject(i);
                        JSONArray jsonArray = object.getJSONArray("data");

                        for (int j = 0; j < jsonArray.length(); j++) {
                            PaymentHistoryBean bean = new PaymentHistoryBean();
                            JSONObject obj1 = jsonArray.getJSONObject(i);
                            bean.setOperator_name(obj1.getString("operator_name"));
                            bean.setService_type(obj1.getString("service_type"));
                            bean.setRecharge_number(obj1.getString("recharge_number"));
                            bean.setTimestamp(obj1.getString("timestamp"));
                            bean.setStatus(obj1.getString("status"));

                            list.add(bean);
                        }
                    }

                    ((Activity) mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mView != null) {
                                mView.hideProgressDialog();
                                mView.displayData(list);
                            }
                        }
                    });

                } catch (final JSONException e) {
                    e.printStackTrace();
                    ((Activity) mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mView != null) {
                                mView.hideProgressDialog();
                            }
                            Constants.displayLongToast(mContext, "" + e.getMessage());
                        }
                    });
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(final VolleyError error) {
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mView != null) {
                            mView.hideProgressDialog();
                        }
                        Constants.displayLongToast(mContext, error.getMessage());
                    }
                });
            }
        });

        AppController.getInstance(mContext).addToRequestQueue(jsonObjReq);
    }


}
