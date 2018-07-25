package com.martaw.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EbayToken {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 1000)
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String token_type;
}