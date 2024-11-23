package restAssured.CountryAPi;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // serialization (object to json)
        Country obj=new Country();
        obj.setPostcode("90210");
        obj.setCountry("United States");
        obj.setCountryAbbrev("US");
        Place obj1=new Place();
        obj1.setPlaceName("Beverly Hills");
        obj1.setLongitude("-118.4065");
        obj1.setState("California");
        obj1.setStateAbbreviation("CA");
        obj1.setLatitude("34.0901");
        obj.setPlaces(List.of(obj1));
        // Serializing to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(obj);
            System.out.println("Serialized JSON: " + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // desrialization
        String jsonString = """
                {
                    "post code": "90210",
                    "country": "United States",
                    "country abbreviation": "US",
                    "places": [
                        {
                            "place name": "Beverly Hills",
                            "longitude": "-118.4065",
                            "state": "California",
                            "state abbreviation": "CA",
                            "latitude": "34.0901"
                        }
                    ]
                }
                """;
        ObjectMapper objectMapper1=new ObjectMapper();
        try{
            Country obj3=objectMapper.readValue(jsonString,Country.class);
            System.out.println(obj3);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
