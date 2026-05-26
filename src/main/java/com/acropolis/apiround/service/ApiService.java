package com.acropolis.apiround.service;

import com.acropolis.apiround.dto.ApiRequest;
import com.acropolis.apiround.dto.ApiResponse;

// service interface for processing bfhl data
public interface ApiService {
    // processes the input data array and returns categorized response
    ApiResponse processData(ApiRequest request);
}
