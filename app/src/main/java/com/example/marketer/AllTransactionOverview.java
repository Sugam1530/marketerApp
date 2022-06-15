package com.example.marketer;

public class AllTransactionOverview {

    private String id;
    private String amount;
    private String type;
    private String user_id;
    private String user_type;
    private String txn_type;
    private String created_at;
    private String updated_at;

    public AllTransactionOverview()
    {}

    public AllTransactionOverview(String id, String amount, String type, String user_id, String user_type, String txn_type, String created_at, String updated_at){
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.user_id = user_id;
        this.user_type = user_type;
        this.txn_type = txn_type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
