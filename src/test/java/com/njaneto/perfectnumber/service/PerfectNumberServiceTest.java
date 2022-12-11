package com.njaneto.perfectnumber.service;

import com.njaneto.perfectnumber.domain.PerfectNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles( "test" )
class PerfectNumberServiceTest {

    @Autowired
    private PerfectNumberService perfectNumberService;

    @Test
    @DisplayName( "must return perfect numbers" )
    void mustReturnPerfectNumbers() {

        PerfectNumber perfectNumber = perfectNumberService.checkPerfectNumber(PerfectNumber.builder()
                        .numbers(List.of(5L,6L,8589869056L, 28L, 137438691328L ,496L, 8128L, 33550336L,6L))
                .build());


        assertEquals( 7,perfectNumber.getNumbers().size());
    }

    @Test
    @DisplayName( "must not return perfect numbers" )
    void mustNotReturnPerfectNumbers() {

        PerfectNumber perfectNumber = perfectNumberService.checkPerfectNumber(PerfectNumber.builder()
                .numbers(List.of(5L,2L, 3L))
                .build());


        assertEquals( 0,perfectNumber.getNumbers().size());
    }
}