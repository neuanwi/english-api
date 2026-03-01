package com.neuanwi.english.controller;

import com.neuanwi.english.dto.WordUpdateRequestDto;
import com.neuanwi.english.service.WordService;
import com.neuanwi.english.word.Word;
import com.neuanwi.english.word.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    @GetMapping
    public List<Word> getWords(@RequestParam(required = false) String word) {
        return wordService.findWords(word);
    }

    @PostMapping
    public Word addWord(@RequestBody Word word) {
        // @RequestBody: "클라이언트가 보낸 JSON 데이터를 자바 객체(Word)로 찰떡같이 변환해 줘!"
        return wordService.saveWord(word);
    }

    @PutMapping
    public ResponseEntity<String> updateWord(
            @PathVariable Long id,
            @RequestBody WordUpdateRequestDto requestDto) {

        // 1. Service 계층에 ID와 수정할 데이터를 넘겨서 업데이트 처리
        wordService.updateWord(id, requestDto);

        // 2. 성공적으로 수정되었다는 응답 반환
        return ResponseEntity.ok("단어가 성공적으로 수정되었습니다.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteWord(@PathVariable Long id) {

        // 1. Service 계층에 ID를 넘겨서 DB에서 삭제 처리
        wordService.deleteWord(id);

        // 2. 성공적으로 삭제되었다는 응답 반환
        return ResponseEntity.ok("단어가 성공적으로 삭제되었습니다.");
    }

}
