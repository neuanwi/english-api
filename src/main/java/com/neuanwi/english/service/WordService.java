package com.neuanwi.english.service;

import com.neuanwi.english.dto.WordUpdateRequestDto;
import com.neuanwi.english.word.Word;
import com.neuanwi.english.word.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public List<Word> findWords(String word) {
        if (word == null) {
            return wordRepository.findAll();
        }
        return wordRepository.findByWord(word);
    }

    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }

    @Transactional
    public void updateWord(Long id, WordUpdateRequestDto requestDto) {
        // 1. Find the existing word in the DB. If it doesn't exist, throw an error!
        Word word = wordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Word not found! ID: " + id));

        // 2. Update the word's data using the DTO.
        // (You will need to create this update() method inside your Word entity class)
        word.update(
                requestDto.getWord(),
                requestDto.getMeaning(),
                requestDto.getLanguage(),
                requestDto.getCategory(),
                requestDto.getExample()
        );

        // Note: We don't need to call wordRepository.save(word) here!
        // @Transactional handles it automatically (Dirty Checking).
    }

    @Transactional
    public void deleteWord(Long id) {
        // 1. Check if the word exists first
        Word word = wordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Word not found! ID: " + id));

        // 2. Delete it from the DB
        wordRepository.delete(word);
    }
}
