package com.acropolis.apiround.service;

import com.acropolis.apiround.dto.ApiRequest;
import com.acropolis.apiround.dto.ApiResponse;

public interface ApiService {
    ApiResponse processData(ApiRequest request);
}
