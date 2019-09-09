
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
    "requestedUrl",
    "items"
})
public class Books {

    @JsonProperty("requestedUrl")
    private String requestedUrl;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("requestedUrl")
    public String getRequestedUrl() {
        return requestedUrl;
    }

    @JsonProperty("requestedUrl")
    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
        return new HashCodeBuilder().append(requestedUrl).append(items).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Books) == false) {
            return false;
        }
        Books rhs = ((Books) other);
        return new EqualsBuilder().append(requestedUrl, rhs.requestedUrl).append(items, rhs.items).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
