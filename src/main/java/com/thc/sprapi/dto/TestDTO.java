package com.thc.sprapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private String inputId;
    private String inputPw;

//    public TestDTO(String inputId, String inputPw) {
//        this.inputId = inputId;
//        this.inputPw = inputPw;
//    }
}
