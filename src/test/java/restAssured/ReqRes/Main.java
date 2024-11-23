package restAssured.ReqRes;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Main {
    String endpoint="https://reqres.in/api/users";
    String id="/{id}";
    @Test
    public void getAllDeatils(){
//        given()
//                .header("Content-Type","application/json")
////                .queryParam("id",1)
//                .pathParam("id",1)
//                .when()
//                .get(endpoint+id)
//                .then()
//                .log().status()
//                .log().body()
//              ;
        Users users = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1) // if you have an ID parameter
                .when()
                .get(endpoint + id)
//                .then()
//                .statusCode(200) // Ensure a successful response
//                .extract()
                .as(Users.class); // Deserialize the response to Users object

        // Log the result to see the data
        System.out.println("Users: " + users.toString());

    }
    @Test
    public void postOneDetails(){
        String body= """
                 {
                            "email": "shivka222nt.wong@reqres.in",
                            "first_name": "shiv",
                            "last_name": "sharmna",
                            "avatar": "https://reqres.in/img/faces/3-image.jpg"
                            }
                """;
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .statusCode(201)
                .log().body()
                .assertThat()
                .body("email",equalTo("shivka222nt.wong@reqres.in"),
                        "first_name",equalTo("shiv"));
//                .body("email",equalTo("shivka222nt.wong@reqres.in")).body("first_name",equalTo("shiv"));
        ;


    }

    @Test
    public  void putDetails(){
        String body= """
                {
                 "email": "shivka222nt.wwong@reqres.in",
                            "first_name": "shiv kant",
                            "last_name": "shawrmna",
                            "avatar": "https://reqres.in/img/faces/3-image.jpg"
                            
                }
                """;
//        Data body=new Data(1,"shivka222nt.wong@reqres.in","Ram","kumar","hhttps://a");

        given()
                .body(body)
                .pathParam("id",32)
                .when()
                .put(endpoint+id)
                .then()
                .log().body().log().status();


    }
@Test
    public void deleteMethod(){
        String body= """
                {
                "id":1
                }
                """;
        given()
                .body(body)

                .when()
                .delete(endpoint)
                .then()
                .log().status();
}

}
