package com.neuanwi.english.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // Spring이 데이터를 담을 '빈 바구니(기본 생성자)'를 자동으로 만들어줌
public class WordUpdateRequestDto {

    private String word;
    private String meaning;
    private String language;
    private String category;
    private String example;

}
