package com.martaw.exercise.model.ebayRespose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Price {
    @Id
    @GeneratedValue
    private Integer id;
    private String value;
    private String currency;
}