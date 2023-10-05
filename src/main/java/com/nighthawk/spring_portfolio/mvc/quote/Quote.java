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

}


