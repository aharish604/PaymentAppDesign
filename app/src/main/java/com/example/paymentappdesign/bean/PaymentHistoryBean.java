package com.example.paymentappdesign.bean;

public class PaymentHistoryBean {

    private String service_type = "";
    private String operator_name = "";
    private String status = "";
    private String recharge_number = "";
    private String timestamp = "";

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecharge_number() {
        return recharge_number;
    }

    public void setRecharge_number(String recharge_number) {
        this.recharge_number = recharge_number;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
