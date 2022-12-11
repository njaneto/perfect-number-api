package com.njaneto.perfectnumber.service;

import com.njaneto.perfectnumber.domain.PerfectNumber;
import com.njaneto.perfectnumber.util.PerfectNumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfectNumberService {

    public PerfectNumber checkPerfectNumber(PerfectNumber request) {

        List<Long> numbers = new ArrayList<>();

        request.getNumbers()
                .stream()
                .sorted()
                .distinct()
                .forEach(number -> {
                    if (PerfectNumberUtils.isPerfectNumber(number)) {
                        numbers.add(number);
                    }
                });

        return PerfectNumber.builder()
                .numbers(numbers)
                .build();
    }

}
