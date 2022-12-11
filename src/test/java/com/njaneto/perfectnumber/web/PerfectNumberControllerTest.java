package com.njaneto.perfectnumber.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.njaneto.perfectnumber.domain.PerfectNumber;
import com.njaneto.perfectnumber.service.PerfectNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PerfectNumberControllerTest {


    private static final String URL = "/perfect/number";

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private PerfectNumberService perfectNumberService;

    @Test
    @DisplayName( "should return perfect numbers" )
    void shouldReturnPerfectNumbers() throws Exception {

        PerfectNumber request = PerfectNumber.builder()
                .numbers(List.of(5L, 6L, 8589869056L, 28L, 137438691328L, 496L, 8128L, 33550336L, 6L))
                .build();

        when(perfectNumberService.checkPerfectNumber(isA(PerfectNumber.class)))
                .thenReturn(PerfectNumber.builder()
                        .numbers(List.of(28L, 6L, 33550336L))
                        .build());

        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(request);

        mockMvc.perform(post(URL)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid", notNullValue()))
                .andExpect(jsonPath("$.hasPerfectNumber", is(Boolean.TRUE)))
                .andExpect(jsonPath("$.numbers", hasSize(3)));

    }

    @Test
    @DisplayName( "should not return perfect numbers" )
    void shouldNotReturnPerfectNumbers() throws Exception {

        PerfectNumber request = PerfectNumber.builder()
                .numbers(Collections.emptyList())
                .build();

        when(perfectNumberService.checkPerfectNumber(isA(PerfectNumber.class)))
                .thenReturn(PerfectNumber.builder()
                        .numbers(Collections.emptyList())
                        .build());

        ObjectMapper mapper = new ObjectMapper();
        String requestJson = mapper.writeValueAsString(request);

        mockMvc.perform(post(URL)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid", notNullValue()))
                .andExpect(jsonPath("$.hasPerfectNumber", is(Boolean.FALSE)))
                .andExpect(jsonPath("$.numbers", hasSize(0)));

    }

}