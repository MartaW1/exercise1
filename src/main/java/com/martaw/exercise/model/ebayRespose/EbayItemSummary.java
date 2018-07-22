package com.martaw.exercise.model.ebayRespose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EbayItemSummary {
    @Id
    @GeneratedValue
    private Integer id;

    private String itemId;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private Price price;
    private String itemHref;
    @OneToOne(cascade = CascadeType.ALL)
    private Seller seller;
    private String condition;
    private String conditionId;
    @OneToOne(cascade = CascadeType.ALL)
    private CurrentBidPrice currentBidPrice;
    private String itemWebUrl;
    @OneToOne(cascade = CascadeType.ALL)
    private ItemLocation itemLocation;
    private boolean adultOnly;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ShippingOption> shippingOptions;
    @ElementCollection
    private List<String> buyingOptions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Categories> categories;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalImage> additionalImages;
}
