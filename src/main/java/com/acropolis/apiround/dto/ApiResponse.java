package com.acropolis.apiround.dto;

import java.util.List;

public class ApiResponse {
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private String college_roll_number;
    private List<Integer> even_numbers;
    private List<Integer> odd_numbers;
    private List<String> alphabets;
    private List<String> special_characters;
    private int sum_of_numbers;
    private String reversed_alternating_caps;

    public ApiResponse() {
    }

    public ApiResponse(boolean is_success, String user_id, String email, String roll_number, String college_roll_number,
                       List<Integer> even_numbers, List<Integer> odd_numbers, List<String> alphabets,
                       List<String> special_characters, int sum_of_numbers, String reversed_alternating_caps) {
        this.is_success = is_success;
        this.user_id = user_id;
        this.email = email;
        this.roll_number = roll_number;
        this.college_roll_number = college_roll_number;
        this.even_numbers = even_numbers;
        this.odd_numbers = odd_numbers;
        this.alphabets = alphabets;
        this.special_characters = special_characters;
        this.sum_of_numbers = sum_of_numbers;
        this.reversed_alternating_caps = reversed_alternating_caps;
    }

    // Getters and Setters
    public boolean isIs_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getCollege_roll_number() {
        return college_roll_number;
    }

    public void setCollege_roll_number(String college_roll_number) {
        this.college_roll_number = college_roll_number;
    }

    public List<Integer> getEven_numbers() {
        return even_numbers;
    }

    public void setEven_numbers(List<Integer> even_numbers) {
        this.even_numbers = even_numbers;
    }

    public List<Integer> getOdd_numbers() {
        return odd_numbers;
    }

    public void setOdd_numbers(List<Integer> odd_numbers) {
        this.odd_numbers = odd_numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getSpecial_characters() {
        return special_characters;
    }

    public void setSpecial_characters(List<String> special_characters) {
        this.special_characters = special_characters;
    }

    public int getSum_of_numbers() {
        return sum_of_numbers;
    }

    public void setSum_of_numbers(int sum_of_numbers) {
        this.sum_of_numbers = sum_of_numbers;
    }

    public String getReversed_alternating_caps() {
        return reversed_alternating_caps;
    }

    public void setReversed_alternating_caps(String reversed_alternating_caps) {
        this.reversed_alternating_caps = reversed_alternating_caps;
    }
}
