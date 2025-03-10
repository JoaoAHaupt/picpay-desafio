package com.joaoahaupt.picpay.service;

import org.springframework.stereotype.Service;

@Service
public class CnpjService {


    public boolean isCnpjValid(String cnpj) {
        String cnpjRegex = cnpj.replaceAll("\\D", "");

        if (cnpjRegex.length() != 14) {
            return false;
        }

        int firstInpesctorDigit = loopCnpj(cnpjRegex.substring(0, 12), 2);
        if (firstInpesctorDigit != Character.getNumericValue(cnpjRegex.charAt(12))) {
            return false;
        }

        String cnpjWithFirstDigit = cnpjRegex.substring(0, 12) + firstInpesctorDigit;

        int secondInpesctorDigit = loopCnpj(cnpjWithFirstDigit, 2);

        return secondInpesctorDigit == Character.getNumericValue(cnpjRegex.charAt(13));
    }

    private static int loopCnpj(String partialCnpj, int initialWeight) {
        int sum = 0;
        int count = initialWeight;

        StringBuilder reversedCnpj = new StringBuilder(partialCnpj).reverse();

        for (int i = 0; i < reversedCnpj.length(); i++) {
            sum = sum + (count * Character.getNumericValue(reversedCnpj.charAt(i)));
            count++;
            if (count == 10) {
                count = 2;
            }
        }

        return sum % 11 < 2 ? 0 : 11 - (sum % 11);
    }


}
