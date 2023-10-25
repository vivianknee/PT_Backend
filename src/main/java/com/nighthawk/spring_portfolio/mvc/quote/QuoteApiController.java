package com.nighthawk.spring_portfolio.mvc.quote;

import java.util.Random;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(path = "/api/quote")

public class QuoteApiController {

    @Autowired
    private QuoteJpaRepository repository; 

    @GetMapping
    public ResponseEntity<List<Quote>> getQuote() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* GET random Quote by emotion */
    @GetMapping("/{emotion}")
    public String getEmotionByRandomEmotion(@PathVariable String emotion) {
        List<Quote> quotes = repository.findByEmotionIgnoreCase(emotion);

        if (!quotes.isEmpty()) {
            int randomIndex = new Random().nextInt(quotes.size());
            Quote randomQuote = quotes.get(randomIndex);
            return randomQuote.getQuote();
        } else {
            return "No quotes found for: " + emotion;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote newQuote) {
        Quote savedQuote = repository.save(newQuote);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @RequestBody Quote updatedQuote) {
        Quote existingQuote = repository.findById(id).orElse(null);
    
        if (existingQuote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        existingQuote.setEmotion(updatedQuote.getEmotion());
        existingQuote.setQuote(updatedQuote.getQuote());
        
        Quote savedQuote = repository.save(existingQuote);
        return new ResponseEntity<>(savedQuote, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        Quote existingQuote = repository.findById(id).orElse(null);
    
        if (existingQuote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        repository.delete(existingQuote);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
