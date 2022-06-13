package com.example.marketer;

import java.util.List;

public class ResponseArrayFarmerOverview {

    private List<FarmerOverview> response;
    public ResponseArrayFarmerOverview()
    {}

    ResponseArrayFarmerOverview(List<FarmerOverview> response)
    {
        this.response = response;
    }

    public List<FarmerOverview> getResponse()
    {
        return this.response;
    }

}
