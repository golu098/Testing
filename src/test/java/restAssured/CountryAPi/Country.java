package restAssured.CountryAPi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Country {
    @JsonProperty("post code")
    private String postcode;
    private String country;
    @JsonProperty("country abbreviation")
    private String countryAbbrev;
    private List<Place>places;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbrev() {
        return countryAbbrev;
    }
    public void setCountryAbbrev(String countryAbbrev) {
        this.countryAbbrev = countryAbbrev;
    }
    public void setPlaces(List<Place> places) {
        this.places = places;
    }
    public List<Place>getPlaces(){
        return places;
    }
    @Override
    public String toString() {
        return "Country{" +
                "postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbrev='" + countryAbbrev + '\'' +
                ", places=" + places +
                '}';
    }

}
