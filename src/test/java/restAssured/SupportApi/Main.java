package restAssured.SupportApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper obj=new ObjectMapper();
        Data data1 = new Data(1,"email","s","c","https://");
        Data data2 = new Data(1,"email2","s","c","https://");
        List<Data> dataList = Arrays.asList(data1,data2);
        Support support = new Support("url.com","text");


        MainClass mainClass=new MainClass(1,1,12,2,dataList,support);
        String json = obj.writeValueAsString(mainClass);
        System.out.println(json);
        String endpoint="https://reqres.in/api/users";

////        given().body(mainClass).when().post(endpoint).then().log().all();
//        given().body(json).when().post(endpoint).then().log().all();

        MainClass obj2 = obj.readValue(json, MainClass.class);
        System.out.println(obj2.toString());

        //deserialisation




    }
}
