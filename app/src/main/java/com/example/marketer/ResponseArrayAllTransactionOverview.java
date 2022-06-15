package com.example.marketer;

import java.util.List;

public class ResponseArrayAllTransactionOverview {

    private List<AllTransactionOverview> response;

    public ResponseArrayAllTransactionOverview()
    {}

    ResponseArrayAllTransactionOverview(List<AllTransactionOverview> response) {this.response = response;}

    public List<AllTransactionOverview> getResponse()
    {
        return this.response;
    }
}
