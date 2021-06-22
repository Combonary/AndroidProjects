package com.example.codingtest.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "wrapperType",
        "kind",
        "collectionId",
        "trackId",
        "artistName",
        "collectionName",
        "trackName",
        "collectionCensoredName",
        "trackCensoredName",
        "collectionArtistId",
        "collectionArtistViewUrl",
        "collectionViewUrl",
        "trackViewUrl",
        "previewUrl",
        "artworkUrl30",
        "artworkUrl60",
        "artworkUrl100",
        "collectionPrice",
        "trackPrice",
        "trackRentalPrice",
        "collectionHdPrice",
        "trackHdPrice",
        "trackHdRentalPrice",
        "releaseDate",
        "collectionExplicitness",
        "trackExplicitness",
        "discCount",
        "discNumber",
        "trackCount",
        "trackNumber",
        "trackTimeMillis",
        "country",
        "currency",
        "primaryGenreName",
        "contentAdvisoryRating",
        "longDescription",
        "hasITunesExtras",
        "artistId",
        "artistViewUrl",
        "shortDescription",
        "isStreamable",
        "collectionArtistName"
})

public class Result {

    @JsonProperty("wrapperType")
    private String wrapperType;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("collectionId")
    private Integer collectionId;
    @JsonProperty("trackId")
    private Integer trackId;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("collectionName")
    private String collectionName;
    @JsonProperty("trackName")
    private String trackName;
    @JsonProperty("collectionCensoredName")
    private String collectionCensoredName;
    @JsonProperty("trackCensoredName")
    private String trackCensoredName;
    @JsonProperty("collectionArtistId")
    private Integer collectionArtistId;
    @JsonProperty("collectionArtistViewUrl")
    private String collectionArtistViewUrl;
    @JsonProperty("collectionViewUrl")
    private String collectionViewUrl;
    @JsonProperty("trackViewUrl")
    private String trackViewUrl;
    @JsonProperty("previewUrl")
    private String previewUrl;
    @JsonProperty("artworkUrl30")
    private String artworkUrl30;
    @JsonProperty("artworkUrl60")
    private String artworkUrl60;
    @JsonProperty("artworkUrl100")
    private String artworkUrl100;
    @JsonProperty("collectionPrice")
    private Double collectionPrice;
    @JsonProperty("trackPrice")
    private Double trackPrice;
    @JsonProperty("trackRentalPrice")
    private Double trackRentalPrice;
    @JsonProperty("collectionHdPrice")
    private Double collectionHdPrice;
    @JsonProperty("trackHdPrice")
    private Double trackHdPrice;
    @JsonProperty("trackHdRentalPrice")
    private Double trackHdRentalPrice;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("collectionExplicitness")
    private String collectionExplicitness;
    @JsonProperty("trackExplicitness")
    private String trackExplicitness;
    @JsonProperty("discCount")
    private Integer discCount;
    @JsonProperty("discNumber")
    private Integer discNumber;
    @JsonProperty("trackCount")
    private Integer trackCount;
    @JsonProperty("trackNumber")
    private Integer trackNumber;
    @JsonProperty("trackTimeMillis")
    private Integer trackTimeMillis;
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("primaryGenreName")
    private String primaryGenreName;
    @JsonProperty("contentAdvisoryRating")
    private String contentAdvisoryRating;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("hasITunesExtras")
    private Boolean hasITunesExtras;
    @JsonProperty("artistId")
    private Integer artistId;
    @JsonProperty("artistViewUrl")
    private String artistViewUrl;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("isStreamable")
    private Boolean isStreamable;
    @JsonProperty("collectionArtistName")
    private String collectionArtistName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("wrapperType")
    public String getWrapperType() {
        return wrapperType;
    }

    @JsonProperty("wrapperType")
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("collectionId")
    public Integer getCollectionId() {
        return collectionId;
    }

    @JsonProperty("collectionId")
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    @JsonProperty("trackId")
    public Integer getTrackId() {
        return trackId;
    }

    @JsonProperty("trackId")
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @JsonProperty("artistName")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("artistName")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("collectionName")
    public String getCollectionName() {
        return collectionName;
    }

    @JsonProperty("collectionName")
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @JsonProperty("trackName")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("trackName")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @JsonProperty("collectionCensoredName")
    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    @JsonProperty("collectionCensoredName")
    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    @JsonProperty("trackCensoredName")
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    @JsonProperty("trackCensoredName")
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    @JsonProperty("collectionArtistId")
    public Integer getCollectionArtistId() {
        return collectionArtistId;
    }

    @JsonProperty("collectionArtistId")
    public void setCollectionArtistId(Integer collectionArtistId) {
        this.collectionArtistId = collectionArtistId;
    }

    @JsonProperty("collectionArtistViewUrl")
    public String getCollectionArtistViewUrl() {
        return collectionArtistViewUrl;
    }

    @JsonProperty("collectionArtistViewUrl")
    public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
        this.collectionArtistViewUrl = collectionArtistViewUrl;
    }

    @JsonProperty("collectionViewUrl")
    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    @JsonProperty("collectionViewUrl")
    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    @JsonProperty("trackViewUrl")
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    @JsonProperty("trackViewUrl")
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    @JsonProperty("previewUrl")
    public String getPreviewUrl() {
        return previewUrl;
    }

    @JsonProperty("previewUrl")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    @JsonProperty("artworkUrl30")
    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    @JsonProperty("artworkUrl30")
    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    @JsonProperty("artworkUrl60")
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    @JsonProperty("artworkUrl60")
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    @JsonProperty("artworkUrl100")
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    @JsonProperty("artworkUrl100")
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    @JsonProperty("collectionPrice")
    public Double getCollectionPrice() {
        return collectionPrice;
    }

    @JsonProperty("collectionPrice")
    public void setCollectionPrice(Double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    @JsonProperty("trackPrice")
    public Double getTrackPrice() {
        return trackPrice;
    }

    @JsonProperty("trackPrice")
    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    @JsonProperty("trackRentalPrice")
    public Double getTrackRentalPrice() {
        return trackRentalPrice;
    }

    @JsonProperty("trackRentalPrice")
    public void setTrackRentalPrice(Double trackRentalPrice) {
        this.trackRentalPrice = trackRentalPrice;
    }

    @JsonProperty("collectionHdPrice")
    public Double getCollectionHdPrice() {
        return collectionHdPrice;
    }

    @JsonProperty("collectionHdPrice")
    public void setCollectionHdPrice(Double collectionHdPrice) {
        this.collectionHdPrice = collectionHdPrice;
    }

    @JsonProperty("trackHdPrice")
    public Double getTrackHdPrice() {
        return trackHdPrice;
    }

    @JsonProperty("trackHdPrice")
    public void setTrackHdPrice(Double trackHdPrice) {
        this.trackHdPrice = trackHdPrice;
    }

    @JsonProperty("trackHdRentalPrice")
    public Double getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    @JsonProperty("trackHdRentalPrice")
    public void setTrackHdRentalPrice(Double trackHdRentalPrice) {
        this.trackHdRentalPrice = trackHdRentalPrice;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("collectionExplicitness")
    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    @JsonProperty("collectionExplicitness")
    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    @JsonProperty("trackExplicitness")
    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    @JsonProperty("trackExplicitness")
    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    @JsonProperty("discCount")
    public Integer getDiscCount() {
        return discCount;
    }

    @JsonProperty("discCount")
    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    @JsonProperty("discNumber")
    public Integer getDiscNumber() {
        return discNumber;
    }

    @JsonProperty("discNumber")
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    @JsonProperty("trackCount")
    public Integer getTrackCount() {
        return trackCount;
    }

    @JsonProperty("trackCount")
    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    @JsonProperty("trackNumber")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @JsonProperty("trackNumber")
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    @JsonProperty("trackTimeMillis")
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    @JsonProperty("trackTimeMillis")
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("primaryGenreName")
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    @JsonProperty("primaryGenreName")
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    @JsonProperty("contentAdvisoryRating")
    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    @JsonProperty("contentAdvisoryRating")
    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("hasITunesExtras")
    public Boolean getHasITunesExtras() {
        return hasITunesExtras;
    }

    @JsonProperty("hasITunesExtras")
    public void setHasITunesExtras(Boolean hasITunesExtras) {
        this.hasITunesExtras = hasITunesExtras;
    }

    @JsonProperty("artistId")
    public Integer getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("artistViewUrl")
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    @JsonProperty("artistViewUrl")
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("isStreamable")
    public Boolean getIsStreamable() {
        return isStreamable;
    }

    @JsonProperty("isStreamable")
    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    @JsonProperty("collectionArtistName")
    public String getCollectionArtistName() {
        return collectionArtistName;
    }

    @JsonProperty("collectionArtistName")
    public void setCollectionArtistName(String collectionArtistName) {
        this.collectionArtistName = collectionArtistName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
