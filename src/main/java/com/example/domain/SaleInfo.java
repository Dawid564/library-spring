
package com.example.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country",
    "saleability",
    "isEbook",
    "buyLink",
    "listPrice",
    "retailPrice",
    "offers"
})
public class SaleInfo {

    @JsonProperty("country")
    private String country;
    @JsonProperty("saleability")
    private String saleability;
    @JsonProperty("isEbook")
    private Boolean isEbook;
    @JsonProperty("buyLink")
    private String buyLink;
    @JsonProperty("listPrice")
    private ListPrice listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice retailPrice;
    @JsonProperty("offers")
    private List<Offer> offers = new ArrayList<Offer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("saleability")
    public String getSaleability() {
        return saleability;
    }

    @JsonProperty("saleability")
    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    @JsonProperty("isEbook")
    public Boolean getIsEbook() {
        return isEbook;
    }

    @JsonProperty("isEbook")
    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    @JsonProperty("buyLink")
    public String getBuyLink() {
        return buyLink;
    }

    @JsonProperty("buyLink")
    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }

    @JsonProperty("listPrice")
    public ListPrice getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("retailPrice")
    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    @JsonProperty("retailPrice")
    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

    @JsonProperty("offers")
    public List<Offer> getOffers() {
        return offers;
    }

    @JsonProperty("offers")
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(saleability).append(isEbook).append(buyLink).append(listPrice).append(retailPrice).append(offers).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SaleInfo) == false) {
            return false;
        }
        SaleInfo rhs = ((SaleInfo) other);
        return new EqualsBuilder().append(country, rhs.country).append(saleability, rhs.saleability).append(isEbook, rhs.isEbook).append(buyLink, rhs.buyLink).append(listPrice, rhs.listPrice).append(retailPrice, rhs.retailPrice).append(offers, rhs.offers).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
