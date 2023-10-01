package com.nighthawk.spring_portfolio.mvc.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@TypeDef(name="json", typeClass=JsonType.class)
@Table(name = "quote")


public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    private String quote; 

    private String emotion; 

    
    public Quote(String quote, String emotion) {
        this.quote = quote; 
        this.emotion = emotion; 
   }

   public static Quote[] init() {

    Quote q1 = new Quote(); 
    q1.setQuote("When life gives you lemons, make lemonade!"); 
    q1.setEmotion("happy"); 
   
    Quote q2 = new Quote(); 
    q2.setQuote("Keep calm and carry on"); 
    q2.setEmotion("sad");

    Quote q3 = new Quote(); 
    q3.setQuote("When it rains, look for the rainbows"); 
    q3.setEmotion("sad");

   Quote quotes[] = {q1, q2, q3}; 
   return(quotes);
   } 

   public static void main(String[] args){
        Quote quotes[] = init();
        for(Quote quote : quotes){
            System.out.println(quote);
        }
   }

}


