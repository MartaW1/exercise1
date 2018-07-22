package com.martaw.exercise.model.ebayRespose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShippingOption {
    @Id
    @GeneratedValue
    private Integer id;
    private String shippingCostType;
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingCost shippingCost;
}