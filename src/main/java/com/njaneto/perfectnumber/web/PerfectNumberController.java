package com.njaneto.perfectnumber.web;

import com.njaneto.perfectnumber.domain.PerfectNumber;
import com.njaneto.perfectnumber.mapper.PerfectNumberMapper;
import com.njaneto.perfectnumber.service.PerfectNumberService;
import com.njaneto.perfectnumber.web.dto.PerfectNumberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class PerfectNumberController {

    @Autowired
    private PerfectNumberService service;

    @PostMapping(value = "/perfect/number", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public PerfectNumberDTO checkPerfectNumber(@Valid @RequestBody PerfectNumber request) {
        return PerfectNumberMapper.toPerfectNumberDTO(service.checkPerfectNumber(request));
    }

}
