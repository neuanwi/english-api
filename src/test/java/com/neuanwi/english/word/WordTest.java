package com.neuanwi.english.word;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordTest {

    @Autowired
    WordRepository wordRepository;

    @Test
    void saveWordTest() {
        Word word = new Word();
        word.setWord("apple");
        word.setMeaning("사과");
        word.setLanguage("EN");
        word.setCategory("N");
        word.setExample("he likes an apple");

        wordRepository.save(word);

        System.out.println("성공");
    }




}
