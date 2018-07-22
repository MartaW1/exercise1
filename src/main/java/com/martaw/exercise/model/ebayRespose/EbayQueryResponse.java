package com.martaw.exercise.model.ebayRespose;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EbayQueryResponse {
    @Id
    @GeneratedValue
    private Integer id;
    private String href;
    private int total;
    private String next;
    @JsonProperty("limit")
    private int pageLimit;
    @JsonProperty("offset")
    private int pageOffset;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EbayItemSummary> itemSummaries;
}
