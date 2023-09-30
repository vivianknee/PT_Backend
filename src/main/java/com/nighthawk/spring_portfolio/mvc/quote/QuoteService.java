package com.nighthawk.spring_portfolio.mvc.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    
    private final QuoteJpaRepository quoteRepository; 

    @Autowired
    public QuoteService(QuoteJpaRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void saveQuotes(Quote[] quotes){
        for (Quote quote:  quotes){
            quoteRepository.save(quote);
        }
    }
}
