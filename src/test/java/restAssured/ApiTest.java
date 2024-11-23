package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void getMethods(){
        String endpoint="https://jsonplaceholder.typicode.com/todos";

        given().
                param("id",1).
//        queryParam("id",1).
                header("Content-Type","application/json").
        accept("application/json").
                when().
                get(endpoint).

                then().
        statusCode(200).
                assertThat().
                body("[0].userId",equalTo(1)).body("[0].id", equalTo(1)).body("[0].title", containsString("delectus aut autem")).body("[0].completed", equalTo(false)).
               log().body();
    }
    @Test
    public void getMethods1(){
        String endpoint="https://jsonplaceholder.typicode.com/todos/{id}";
        given().
                pathParams("id",1).
                header("Content-Type","application/json").
                when().
                get(endpoint).
                then().
        statusCode(200).
                assertThat().
                body("userId",equalTo(1)).body("id", equalTo(1)).body("title", containsString("delectus aut autem")).body("completed", equalTo(false)).
               log().body();
    }
    @Test
    public void postMethod() {
        String endpoint = "https://jsonplaceholder.typicode.com/todos"; // Corrected URL
//        String body = "{ \"userId\": 1, \"id\": 101, \"title\": \"New Todo Item\", \"completed\": false }"; // JSON body
Body body=new Body(1,1,"Todo Item",false);
        given()
                .header("Content-Type", "application/json") // Correct Content-Type
                .body(body) // The body should be a valid JSON string
                .when()
                .post(endpoint) // POST request to the endpoint
                .then()
                .log().status().log().body();  // Logs the status of the response
    }
    @Test
    public  void postMethodUsingDefinedBody(){
        String endpoint = "https://jsonplaceholder.typicode.com/todos"; // Corrected URL
        Body body=new Body(1,2, "main/shiv",false);
        given().header("Content-Type","application/json").body(body).when().post(endpoint).then().statusCode(201).log().body();
    }
    @Test
    public  void putMethod(){
        String endpoint = "https://jsonplaceholder.typicode.com/todos/{id}"; // Corrected URL
        int userId=1;
        Body body=new Body(userId,1, "main/shiv",false);
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .put(endpoint,userId)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public  void patchMethod(){
        String endpoint = "https://jsonplaceholder.typicode.com/todos/{id}"; // Corrected URL
        int userId=1;
        Body body=new Body(userId,1, "main/shiv",false);
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .patch(endpoint,userId)
                .then()
                .statusCode(200)
                .log().body();
    }
    @Test
    public void deleteMethod(){
        String endpoint = "https://jsonplaceholder.typicode.com/todos/{id}"; // Corrected URL
        int userId=1;
        Body body=new Body(userId,1, "main/shiv",false);
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .delete(endpoint,userId)
                .then()
                .statusCode(200)
                .log().body();
    }
    @Test
    public void deleteMethod1(){
        String endpoint = "https://jsonplaceholder.typicode.com/todos"; // Corrected URL
   String body= """
           {
           "[0].id":1
           }
           """;
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .delete(endpoint)
                .then()
                .statusCode(200)
                .log().body();
    }
    @Test
    public void getDeserializedMethod() {
        String endPoint = "https://jsonplaceholder.typicode.com/todos/1";

        // Create expected object
        Body expectedProduct = new Body(1, 1, "delectus aut autem", false);

        // Make the GET request and deserialize the response
        Body actualProduct =
                given()
                        .header("Content-Type", "application/json")
                        .when()
                        .get(endPoint)
                        .as(Body.class);

        System.out.println(actualProduct.isCompleted());

        // Assert that the actual product matches the expected product
//        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));
    }

}
