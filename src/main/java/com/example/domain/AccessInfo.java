
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
    "country",
    "viewability",
    "embeddable",
    "publicDomain",
    "textToSpeechPermission",
    "epub",
    "pdf",
    "webReaderLink",
    "accessViewStatus",
    "quoteSharingAllowed"
})
public class AccessInfo {

    @JsonProperty("country")
    private String country;
    @JsonProperty("viewability")
    private String viewability;
    @JsonProperty("embeddable")
    private Boolean embeddable;
    @JsonProperty("publicDomain")
    private Boolean publicDomain;
    @JsonProperty("textToSpeechPermission")
    private String textToSpeechPermission;
    @JsonProperty("epub")
    private Epub epub;
    @JsonProperty("pdf")
    private Pdf pdf;
    @JsonProperty("webReaderLink")
    private String webReaderLink;
    @JsonProperty("accessViewStatus")
    private String accessViewStatus;
    @JsonProperty("quoteSharingAllowed")
    private Boolean quoteSharingAllowed;
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

    @JsonProperty("viewability")
    public String getViewability() {
        return viewability;
    }

    @JsonProperty("viewability")
    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    @JsonProperty("embeddable")
    public Boolean getEmbeddable() {
        return embeddable;
    }

    @JsonProperty("embeddable")
    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    @JsonProperty("publicDomain")
    public Boolean getPublicDomain() {
        return publicDomain;
    }

    @JsonProperty("publicDomain")
    public void setPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    @JsonProperty("textToSpeechPermission")
    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    @JsonProperty("textToSpeechPermission")
    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    @JsonProperty("epub")
    public Epub getEpub() {
        return epub;
    }

    @JsonProperty("epub")
    public void setEpub(Epub epub) {
        this.epub = epub;
    }

    @JsonProperty("pdf")
    public Pdf getPdf() {
        return pdf;
    }

    @JsonProperty("pdf")
    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    @JsonProperty("webReaderLink")
    public String getWebReaderLink() {
        return webReaderLink;
    }

    @JsonProperty("webReaderLink")
    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    @JsonProperty("accessViewStatus")
    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    @JsonProperty("accessViewStatus")
    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    @JsonProperty("quoteSharingAllowed")
    public Boolean getQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    @JsonProperty("quoteSharingAllowed")
    public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
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
        return new HashCodeBuilder().append(country).append(viewability).append(embeddable).append(publicDomain).append(textToSpeechPermission).append(epub).append(pdf).append(webReaderLink).append(accessViewStatus).append(quoteSharingAllowed).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccessInfo) == false) {
            return false;
        }
        AccessInfo rhs = ((AccessInfo) other);
        return new EqualsBuilder().append(country, rhs.country).append(viewability, rhs.viewability).append(embeddable, rhs.embeddable).append(publicDomain, rhs.publicDomain).append(textToSpeechPermission, rhs.textToSpeechPermission).append(epub, rhs.epub).append(pdf, rhs.pdf).append(webReaderLink, rhs.webReaderLink).append(accessViewStatus, rhs.accessViewStatus).append(quoteSharingAllowed, rhs.quoteSharingAllowed).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
