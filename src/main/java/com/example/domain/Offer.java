
package com.example.domain;

import java.util.HashMap;
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
    "finskyOfferType",
    "listPrice",
    "retailPrice"
})
public class Offer {

    @JsonProperty("finskyOfferType")
    private Integer finskyOfferType;
    @JsonProperty("listPrice")
    private ListPrice_ listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice_ retailPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("finskyOfferType")
    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    @JsonProperty("finskyOfferType")
    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    @JsonProperty("listPrice")
    public ListPrice_ getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("retailPrice")
    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    @JsonProperty("retailPrice")
    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
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
        return new HashCodeBuilder().append(finskyOfferType).append(listPrice).append(retailPrice).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Offer) == false) {
            return false;
        }
        Offer rhs = ((Offer) other);
        return new EqualsBuilder().append(finskyOfferType, rhs.finskyOfferType).append(listPrice, rhs.listPrice).append(retailPrice, rhs.retailPrice).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
