package com.nighthawk.spring_portfolio.mvc.quote;

import java.util.Random;

import javax.annotation.PostConstruct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/quotes")

public class QuoteApiController {
    @Autowired
    private QuoteService quoteService; 

    @Autowired
    private QuoteJpaRepository repository; 

    @PostConstruct
    public void init() {
        Quote[] quotes = Quote.init();
        quoteService.saveQuotes(quotes);
    }
    /* GET List of Quotes */
    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuote() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* GET random Quote by emotion */
    @GetMapping("/quotes/{emotion}")
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
}
