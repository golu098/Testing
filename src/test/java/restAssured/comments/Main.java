package restAssured.comments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Main {

    String endpoint="https://jsonplaceholder.typicode.com/comments";
    // initilizae object mapper
    ObjectMapper objectMapper=new ObjectMapper();
    @Test
    public void serilizationMethod(){
        Comments body=new Comments(1,699,"id labore ex et quam laborum","Eliseo@gardner.biz","laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
            given().
                    header("Content-Type","application/json").
                    body(body).
                    when().
                    post(endpoint).
                    then().
                    assertThat().
                    statusCode(201).
                    log().all();
    }

    @Test
    public void serilizationUsingObjectMapper() throws IOException {
        // instance
        Comments body=new Comments(1,699,"id labore ex et quam laborum","Eliseo@gardner.biz","laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
        String obj=objectMapper.writeValueAsString(body);
        System.out.println("Seriliazed Json"+obj);

    }
    @Test
    public void desrilizationObjectMapper() throws  IOException{
        String body= """
                {
                  "postId": 1,
                  "id": 1,
                  "name": "id labore ex et quam laborum",
                  "email": "Eliseo@gardner.biz",
                  "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
                }
                """;
        Comments comments=objectMapper.readValue(body, Comments.class);
        System.out.println(comments.getEmail());
    }
    @Test
    public void desrilizationMethod(){
        Comments res=given()
                .contentType("application/json")
                .when()
                .get("https://jsonplaceholder.typicode.com/comments/1")
                .then()
                .extract()
                .as(Comments.class);
        System.out.println(res.toString());

    }
    @Test
    public void getAllEmailId(){
        // if u use Comments then use getList else use String
        List<String> emailList=given()
                .header("Content-Type","application-json")
                .when()
                .get(endpoint)
                .then()
                .extract()
                .jsonPath()
                .getList("email");
//                .getList(".",Comments.class);
        emailList.stream().forEach(System.out::println);
//        for(Comments i:emailList){
//            System.out.println(i.getEmail());
//        }
    }
}
