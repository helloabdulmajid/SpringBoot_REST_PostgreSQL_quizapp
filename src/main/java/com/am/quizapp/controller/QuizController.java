package com.am.quizapp.controller;

import com.am.quizapp.model.QuestionWrapper;
import com.am.quizapp.model.Response;
import com.am.quizapp.service.QuizService;
import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
   @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam
   String title)
   {
    return quizService.createQuiz(category,numQ,title);
   }

   @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuiestions(@PathVariable Integer id)
   {
       return quizService.getQuizQuiestions(id);
   }

   @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
   {
    return quizService.calculateResult(id,responses);
   }
}
