
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
    "amountInMicros",
    "currencyCode"
})
public class ListPrice_ {

    @JsonProperty("amountInMicros")
    private Double amountInMicros;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amountInMicros")
    public Double getAmountInMicros() {
        return amountInMicros;
    }

    @JsonProperty("amountInMicros")
    public void setAmountInMicros(Double amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
        return new HashCodeBuilder().append(amountInMicros).append(currencyCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ListPrice_) == false) {
            return false;
        }
        ListPrice_ rhs = ((ListPrice_) other);
        return new EqualsBuilder().append(amountInMicros, rhs.amountInMicros).append(currencyCode, rhs.currencyCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
