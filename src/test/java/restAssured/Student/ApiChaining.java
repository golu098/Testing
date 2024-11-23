package restAssured.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiChaining{

    public static void main(String[] args) {
        // Step 1: Create a new student
        String studentId = given()
                .header("Content-Type", "application/json")
                .body("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"}")
                .when()
                .post("http://localhost:8080/students")
                .then()
                .statusCode(200)
                .extract().path("id"); // Extract student ID from response

        // Step 2: Get the student details
        given()
                .pathParam("id", studentId)
                .when()
                .get("http://localhost:8080/students/{id}")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("John"));

        // Step 3: Update the student details
        given()
                .pathParam("id", studentId)
                .header("Content-Type", "application/json")
                .body("{\"firstName\":\"Jane\"}")
                .when()
                .put("http://localhost:8080/students/{id}")
                .then()
                .statusCode(200);

        // Step 4: Delete the student
        given()
                .pathParam("id", studentId)
                .when()
                .delete("http://localhost:8080/students/{id}")
                .then()
                .statusCode(204);
    }
}
