package com.nighthawk.spring_portfolio.mvc.quote;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface QuoteJpaRepository extends JpaRepository<Quote, Long>{
    void save(String Quote); 
    List<Quote> findByEmotionIgnoreCase(String emotion);
}

