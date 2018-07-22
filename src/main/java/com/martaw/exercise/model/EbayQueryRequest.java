package com.martaw.exercise.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EbayQueryRequest {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(max = 20)
    @NotBlank
    private String query;
    private Integer maxResults;
    private Integer resultOffset;
    private Integer maxItemPrice;
}