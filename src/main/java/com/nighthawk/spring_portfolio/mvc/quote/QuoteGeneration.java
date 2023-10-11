package com.nighthawk.spring_portfolio.mvc.quote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuoteGeneration {

    @Bean
    CommandLineRunner commandLineRunner(
            QuoteJpaRepository repository) {
        return args -> {
            Quote q1 = new Quote(
                "When life gives you lemons, make lemonade", 
                "happy"
            ); 

            Quote q2 = new Quote(
                "Keep calm and carry on", 
                "sad"
            );

            Quote q3 = new Quote(
                "Believe in yourself, and you'll achieve great things.", 
                "sad"
            );

            Quote q4 = new Quote(
                "Happiness is a journey, not a destination.", 
                "sad"
            );

            Quote q5 = new Quote(
                "Tough times never last, but tough people do.", 
                "sad"
            );

            Quote q6 = new Quote(
                "No matter how much it hurts now, someday you will look back and realize your struggles changed your life for the better", 
                "sad"
            );

            Quote q7 = new Quote(
                "Every day may not be good, but there's something good in every day", 
                "sad"
            );

            Quote q8 = new Quote(
                "You are stronger than you think and more loved than you know", 
                "sad"
            );

            Quote q9 = new Quote(
                "Every setback is a setup for a comeback.", 
                "sad"
            );

            Quote q10 = new Quote(
                "People who wonder if the glass is half empty or full miss the point. The glass is refillable", 
                "sad"
            );

            Quote q11 = new Quote(
                "You alone are enough. You have nothing to prove to anybody", 
                "sad"
            );

            Quote q12 = new Quote(
                "You are living. You occupy space. You have a mass. You matter.", 
                "sad"
            );

            Quote q13 = new Quote(
                "Count your age by friends, not years. Count your life by smiles, not tears.", 
                "happy"
            );

            Quote q14 = new Quote(
                "The most important thing is to enjoy your life—to be happy—it's all that matters", 
                "happy"
            );

            Quote q15 = new Quote(
                "Happiness is when what you think, what you say, and what you do are in harmony", 
                "happy"
            );

            Quote q16 = new Quote(
                "A pleasant surprise is waiting for you today", 
                "happy"
            );

            Quote q17 = new Quote(
                "You are a magnet for good luck and positive energy", 
                "happy"
            );

            Quote q18 = new Quote(
                "Happiness is the art of never holding in your mind the memory of any unpleasant thing that has passed", 
                "happy"
            );

            Quote q19 = new Quote(
                "Happiness is a warm puppy. Radiate warm energy today", 
                "happy"
            );

            Quote q20 = new Quote(
                "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful", 
                "happy"
            );

            Quote q21 = new Quote(
                "Holding on to anger is like grasping a hot coal with the intent of throwing it at someone else; you are the one who gets burned", 
                "angry"
            );

            Quote q22 = new Quote(
                "If it comes, let it come. If it goes, it's ok, let it go. Let things come and go. Stay calm, don't let anything disturb your peace, and carry on", 
                "angry"
            );

            Quote q23 = new Quote(
                "Getting angry in a stressful situation is like trying to clean something with dirt.", 
                "angry"
            );

            Quote q24 = new Quote(
                "Free your hearts of anxiety, pain and anger, to have peace within your heart and soul.", 
                "angry"
            );

            Quote q25 = new Quote(
                "Anger is a boomerang", 
                "angry"
            );

            Quote q26 = new Quote(
                "Whoever is able to anger you is able to control you.", 
                "angry"
            );

            Quote q27 = new Quote(
                "Reacting in anger or annoyance will not advance one's ability to persuade", 
                "angry"
            );

            Quote q28 = new Quote(
                "When one burns one's bridges, what a very nice fire it makes.", 
                "angry"
            );

            Quote q29 = new Quote(
                "You don’t have to control your thoughts, you just have to stop letting them control you", 
                "angry"
            );

            Quote q30 = new Quote(
                "The day she let go of the things that were weighing her down, was the day she began to shine the brightest", 
                "angry"
            );

            Quote q31 = new Quote(
                "Step outside for a while — calm your mind. It is better to hug a tree than bang your head against a wall continually", 
                "angry"
            );

            repository.saveAll(
                    List.of(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28, q29, q30, q31)
            );
        };
    }
}
