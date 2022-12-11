package com.njaneto.perfectnumber.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PerfectNumberUtils {
    public static Boolean isPerfectNumber(long number) {

        if (number <= 1) {
            return Boolean.FALSE;
        }

        long sum = 1;
        for (long i = 2;  i * i <= number; i++) {
            if (number % i == 0) {
                if (i * i == number) {
                    sum += i;
                } else {
                    sum += i + (number / i);
                }
            }
        }

        if (sum == number) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

}
