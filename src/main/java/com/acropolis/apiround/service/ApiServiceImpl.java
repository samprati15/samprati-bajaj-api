package com.acropolis.apiround.service;

import com.acropolis.apiround.dto.ApiRequest;
import com.acropolis.apiround.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private static final String USER_ID = "samprati_sawala_15102005";
    private static final String EMAIL = "sampratisawala230058@acropolis.in";
    private static final String ROLL_NUMBER = "0827CY231061";

    @Override
    public ApiResponse processData(ApiRequest request) {
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        int sumOfNumbers = 0;
        StringBuilder allLetters = new StringBuilder();

        if (request != null && request.getData() != null) {
            for (String str : request.getData()) {
                if (str == null) {
                    continue;
                }

                // Check if the entire string can be parsed as an integer
                boolean isNumber = false;
                int num = 0;
                try {
                    num = Integer.parseInt(str.trim());
                    isNumber = true;
                } catch (NumberFormatException e) {
                    // Not a standard integer
                }

                if (isNumber) {
                    // Return numbers as strings per spec
                    if (num % 2 == 0) {
                        evenNumbers.add(str.trim());
                    } else {
                        oddNumbers.add(str.trim());
                    }
                    sumOfNumbers += num;
                } else {
                    // Check if it consists only of alphabetic characters
                    boolean isAlphabetic = !str.isEmpty() && str.chars().allMatch(Character::isLetter);
                    if (isAlphabetic) {
                        alphabets.add(str.toUpperCase());
                    } else {
                        specialCharacters.add(str);
                    }

                    // Extract any alphabetical characters present in this string for the concatenated string
                    for (char ch : str.toCharArray()) {
                        if (Character.isLetter(ch)) {
                            allLetters.append(ch);
                        }
                    }
                }
            }
        }

        // Process the reversed alternating caps string (concat_string)
        String reversed = allLetters.reverse().toString();
        StringBuilder altCaps = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (i % 2 == 0) {
                altCaps.append(Character.toUpperCase(ch));
            } else {
                altCaps.append(Character.toLowerCase(ch));
            }
        }

        ApiResponse response = new ApiResponse();
        response.setIs_success(true);
        response.setUser_id(USER_ID);
        response.setEmail(EMAIL);
        response.setRoll_number(ROLL_NUMBER);
        response.setEven_numbers(evenNumbers);
        response.setOdd_numbers(oddNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);
        response.setSum(String.valueOf(sumOfNumbers));
        response.setConcat_string(altCaps.toString());

        return response;
    }
}
