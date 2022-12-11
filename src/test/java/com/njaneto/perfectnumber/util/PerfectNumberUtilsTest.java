package com.njaneto.perfectnumber.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles( "test" )
class PerfectNumberUtilsTest {

    @Test
    @DisplayName( "must check if the number is perfect" )
    void mustCheckIfTheNumberIsPerfect() {

        assertTrue(PerfectNumberUtils.isPerfectNumber(28));
        assertFalse(PerfectNumberUtils.isPerfectNumber(1));
        assertFalse(PerfectNumberUtils.isPerfectNumber(-1));
        assertTrue(PerfectNumberUtils.isPerfectNumber(137438691328L));
        assertFalse(PerfectNumberUtils.isPerfectNumber(137438691329L));

    }
}