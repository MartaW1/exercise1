package com.martaw.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EbayQueryResponse {
    private String href;
    private int total;
    private String next;
    private int limit;
    private int offset;
    private List<EbayItemSummary> itemSummaries;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EbayItemSummary {
        private String itemId;
        private String title;
        private Price price;
        private String itemHref;
        private Seller seller;
        private String condition;
        private String conditionId;
        private CurrentBidPrice currentBidPrice;
        private String itemWebUrl;
        private ItemLocation itemLocation;
        private boolean adultOnly;
        private Image image;
        private List<ShippingOption> shippingOptions;
        private List<String> buyingOptions;
        private List<Categories> categories;
        private List<AdditionalImage> additionalImages;


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Price {

            private String value;
            private String currency;

        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Seller {

            private String username;
            private String feedbackPercentage;
            private int feedbackScore;
        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class CurrentBidPrice {
            private String value;
            private String currency;
        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ItemLocation {
            private String postalCode;
            private String country;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Image {
            private String imageUrl;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ShippingOption {

            private String shippingCostType;
            private ShippingCost shippingCost;


            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class ShippingCost {
                private String value;
                private String currency;
            }
        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Categories {

            private String categoryId;
        }


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AdditionalImage {

            private String imageUrl;
        }
    }
}