package com.neuanwi.english.controller;

import com.neuanwi.english.service.WordService;
import com.neuanwi.english.word.Word;
import com.neuanwi.english.word.WordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public List<Word> getAllWords() {
        return wordService.findAllWords();
    }

    @PostMapping("/words")
    public Word addWord(@RequestBody Word word) {
        // @RequestBody: "클라이언트가 보낸 JSON 데이터를 자바 객체(Word)로 찰떡같이 변환해 줘!"
        return wordService.saveWord(word);
    }

}
