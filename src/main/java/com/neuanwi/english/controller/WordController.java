package com.neuanwi.english.controller;

import com.neuanwi.english.word.Word;
import com.neuanwi.english.word.WordRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class WordController {

    private final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/words")
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }


}
