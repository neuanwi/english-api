package com.neuanwi.english.service;

import com.neuanwi.english.word.Word;
import com.neuanwi.english.word.WordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> findAllWords() {
        return wordRepository.findAll();
    }

    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }
}
