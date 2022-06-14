package com.example.marketer;

public class AddFarmerOverview {

    private float status;
    private String messege;

    public AddFarmerOverview()
    {}

    public AddFarmerOverview(float status, String messege){
        this.status = status;
        this.messege = messege;
    }


    // Getter Methods

    public float getStatus() {
        return status;
    }

    public String getMessege() {
        return messege;
    }

    // Setter Methods

    public void setStatus(float status) {
        this.status = status;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
