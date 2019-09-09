
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
    "smallThumbnail",
    "thumbnail"
})
public class ImageLinks {

    @JsonProperty("smallThumbnail")
    private String smallThumbnail;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("smallThumbnail")
    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    @JsonProperty("smallThumbnail")
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
        return new HashCodeBuilder().append(smallThumbnail).append(thumbnail).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ImageLinks) == false) {
            return false;
        }
        ImageLinks rhs = ((ImageLinks) other);
        return new EqualsBuilder().append(smallThumbnail, rhs.smallThumbnail).append(thumbnail, rhs.thumbnail).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
