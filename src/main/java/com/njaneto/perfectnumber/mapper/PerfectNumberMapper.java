package com.njaneto.perfectnumber.mapper;

import com.njaneto.perfectnumber.domain.PerfectNumber;
import com.njaneto.perfectnumber.web.dto.PerfectNumberDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PerfectNumberMapper {

    public static PerfectNumberDTO toPerfectNumberDTO(PerfectNumber perfectNumber) {
        return perfectNumber != null ? PerfectNumberDTO.builder()
                .uuid(UUID.randomUUID().toString())
                .hasPerfectNumber(!perfectNumber.getNumbers().isEmpty())
                .numbers(perfectNumber.getNumbers())
                .build() : null;
    }
}
