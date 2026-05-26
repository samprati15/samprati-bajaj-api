package com.acropolis.apiround.controller;

import com.acropolis.apiround.dto.ApiRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetEndpoint() throws Exception {
        mockMvc.perform(get("/bfhl"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation_code", is(1)));
    }

    @Test
    public void testPostWithMixedData() throws Exception {
        ApiRequest request = new ApiRequest(Arrays.asList("a", "1", "3", "b", "@", "4"));

        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.user_id", is("samprati_sawala_15102005")))
                .andExpect(jsonPath("$.email", is("sampratisawala230058@acropolis.in")))
                .andExpect(jsonPath("$.roll_number", is("0827CY231061")))
                .andExpect(jsonPath("$.college_roll_number", is("0827CY231061")))
                .andExpect(jsonPath("$.even_numbers", contains(4)))
                .andExpect(jsonPath("$.odd_numbers", containsInAnyOrder(1, 3)))
                .andExpect(jsonPath("$.alphabets", containsInAnyOrder("A", "B")))
                .andExpect(jsonPath("$.special_characters", contains("@")))
                .andExpect(jsonPath("$.sum_of_numbers", is(8)))
                // reversed letters: b, a -> alternating caps: Ba
                .andExpect(jsonPath("$.reversed_alternating_caps", is("Ba")));
    }

    @Test
    public void testPostWithNumbersOnly() throws Exception {
        ApiRequest request = new ApiRequest(Arrays.asList("2", "7", "10", "15"));

        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.even_numbers", containsInAnyOrder(2, 10)))
                .andExpect(jsonPath("$.odd_numbers", containsInAnyOrder(7, 15)))
                .andExpect(jsonPath("$.alphabets", is(empty())))
                .andExpect(jsonPath("$.sum_of_numbers", is(34)))
                .andExpect(jsonPath("$.reversed_alternating_caps", is("")));
    }

    @Test
    public void testPostWithAlphabetsOnly() throws Exception {
        ApiRequest request = new ApiRequest(Arrays.asList("x", "y", "z"));

        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.even_numbers", is(empty())))
                .andExpect(jsonPath("$.odd_numbers", is(empty())))
                .andExpect(jsonPath("$.alphabets", containsInAnyOrder("X", "Y", "Z")))
                .andExpect(jsonPath("$.sum_of_numbers", is(0)))
                // reversed letters: z, y, x -> alternating caps: ZyX
                .andExpect(jsonPath("$.reversed_alternating_caps", is("ZyX")));
    }

    @Test
    public void testPostWithEmptyData() throws Exception {
        ApiRequest request = new ApiRequest(Collections.emptyList());

        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.even_numbers", is(empty())))
                .andExpect(jsonPath("$.odd_numbers", is(empty())))
                .andExpect(jsonPath("$.alphabets", is(empty())))
                .andExpect(jsonPath("$.sum_of_numbers", is(0)))
                .andExpect(jsonPath("$.reversed_alternating_caps", is("")));
    }
}
