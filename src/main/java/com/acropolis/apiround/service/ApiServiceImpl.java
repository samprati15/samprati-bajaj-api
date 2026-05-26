package com.acropolis.apiround.service;

import com.acropolis.apiround.dto.ApiRequest;
import com.acropolis.apiround.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// implementation of the service interface for processing the bfhl data
@Service
public class ApiServiceImpl implements ApiService {

    // my details for the response
    private static final String USER_ID = "samprati_sawala_15102005";
    private static final String EMAIL = "sampratisawala230058@acropolis.in";
    private static final String ROLL_NUMBER = "0827CY231061";

    @Override
    public ApiResponse processData(ApiRequest request) {
        // lists to store separated data
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

                // try to parse as integer
                boolean isNumber = false;
                int num = 0;
                try {
                    num = Integer.parseInt(str.trim());
                    isNumber = true;
                } catch (NumberFormatException e) {
                    // not a number, check other types
                }

                if (isNumber) {
                    // separate even and odd, keep as string
                    if (num % 2 == 0) {
                        evenNumbers.add(str.trim());
                    } else {
                        oddNumbers.add(str.trim());
                    }
                    sumOfNumbers += num;
                } else {
                    // check if the whole string is alphabetic
                    boolean isAlphabetic = !str.isEmpty() && str.chars().allMatch(Character::isLetter);
                    if (isAlphabetic) {
                        alphabets.add(str.toUpperCase());
                    } else {
                        // anything else goes to special characters
                        specialCharacters.add(str);
                    }

                    // extract individual letters for concat_string
                    for (char ch : str.toCharArray()) {
                        if (Character.isLetter(ch)) {
                            allLetters.append(ch);
                        }
                    }
                }
            }
        }

        // reverse the letters and apply alternating caps (uppercase at even index, lowercase at odd)
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

        // build the response object
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
