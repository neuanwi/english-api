package com.neuanwi.english.word;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. 특정 언어 이름 대신 범용적인 이름 사용
    private String word;     // 단어 (예: apple, manzana, りんご)
    private String meaning;  // 뜻 (예: 사과)
    private String note;     // 예문이나 메모

    // 2. 언어 구분자 추가
    private String language; // 언어 코드 (예: "EN", "ES", "JA" 등)
}
