package com.acropolis.apiround.dto;

import java.util.List;

public class ApiRequest {
    private List<String> data;

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

    @Override
    public String toString() {
        return "ApiRequest{" +
                "data=" + data +
                '}';
    }
}
