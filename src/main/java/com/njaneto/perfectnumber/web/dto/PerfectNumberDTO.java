package com.njaneto.perfectnumber.web.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PerfectNumberDTO {

    private String uuid;
    private Boolean hasPerfectNumber;
    private List<Long> numbers;
}
