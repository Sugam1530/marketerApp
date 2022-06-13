package com.example.marketer;

public class FarmerOverview {

    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String mkt_id;
    private String is_active;
    private String wallet_balance;
    private String created_at;
    private String updated_at;

    public FarmerOverview()
    {}

    public FarmerOverview(String id, String name, String username, String email, String password, String wallet_balance){
        this.id = id;
        this.email= email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.wallet_balance = wallet_balance;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMkt_id() {
        return mkt_id;
    }

    public String getIs_active() {
        return is_active;
    }

    public String getWallet_balance() {
        return wallet_balance;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMkt_id(String mkt_id) {
        this.mkt_id = mkt_id;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public void setWallet_balance(String wallet_balance) {
        this.wallet_balance = wallet_balance;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
