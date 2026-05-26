package com.acropolis.apiround.controller;

import com.acropolis.apiround.dto.ApiRequest;
import com.acropolis.apiround.dto.ApiResponse;
import com.acropolis.apiround.service.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// main controller for the bfhl api
@RestController
@CrossOrigin("*")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    // POST /bfhl - processes the data array and returns categorized response
    @PostMapping("/bfhl")
    public ApiResponse processData(@RequestBody ApiRequest request) {
        return apiService.processData(request);
    }

    // GET /bfhl - returns operation code 1
    @GetMapping("/bfhl")
    public Map<String, Integer> getOperationCode() {
        return Map.of("operation_code", 1);
    }

}
