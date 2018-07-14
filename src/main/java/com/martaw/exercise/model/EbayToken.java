package com.martaw.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EbayToken {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String token_type;
}