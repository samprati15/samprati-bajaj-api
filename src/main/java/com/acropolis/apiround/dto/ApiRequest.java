package com.acropolis.apiround.dto;

import java.util.List;

// request DTO - takes in the data array from the POST request body
public class ApiRequest {
    private List<String> data;  // array of strings containing numbers, alphabets, special chars

    public ApiRequest() {
    }

    public ApiRequest(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
