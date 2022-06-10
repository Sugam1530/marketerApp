package com.example.marketer;

public class ResponseArrayMarketerLoginOverview {

    private int status;
    private MarketerLoginOverview response;
    public ResponseArrayMarketerLoginOverview()
    {}

    ResponseArrayMarketerLoginOverview(MarketerLoginOverview response, int status)
    {this.response = response; this.status = status;}
    public MarketerLoginOverview getResponse() { return this.response;}
    public int getStatus() { return this.status;}

}
