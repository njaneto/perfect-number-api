package com.njaneto.perfectnumber.mapper;

import com.njaneto.perfectnumber.domain.PerfectNumber;
import com.njaneto.perfectnumber.web.dto.PerfectNumberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PerfectNumberMapperTest {

    @Test
    @DisplayName( "should return null" )
    void shouldReturnNull() {

        assertNull(PerfectNumberMapper.toPerfectNumberDTO(null));

    }

    @Test
    @DisplayName( "should return the mapped object to PerfectNumberDTO" )
    void shouldReturnTheMappedObjectToPerfectNumberDTO() {

        PerfectNumberDTO dto = PerfectNumberMapper
                .toPerfectNumberDTO(PerfectNumber.builder()
                        .numbers(List.of(28L, 6L, 33550336L))
                        .build());

        assertTrue(dto.getHasPerfectNumber());
        assertFalse(dto.getUuid().isEmpty());
        assertFalse(dto.getNumbers().isEmpty());

    }

}