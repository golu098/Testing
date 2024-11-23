package restAssured.Student;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestFile {
//    @Test
//    public void getStudentDetails(){
//        String endpoint="http://localhost:8080/students";
//    String token ="ssjd";
//        // Specify the file to be uploaded
//        File file = new File("path/to/your/file.txt"); // Update with the path to your file
//
//        given()
//                .queryParam("id",3)
//                .header("Content-type","application/json")
//                .auth()
//                .digest("username", "password") // Replace with actual credentials
//                .auth()
//                .preemptive() // Use preemptive to send credentials with the request
//                .basic("username", "password") // Replace with actual credentials
//                .header("Authorization", "Bearer " + token)
//                .cookie("session_id", "your_session_id") // Set a single cookie
//                .cookies("session_id", "your_session_id", "user_id", "your_user_id") // Set multiple cookies
//                .cookie("session_id", "your_session_id") // Set the cookie for the DELETE request
//                // FOR FILE UPLOAD
//                .multiPart("form field name", fileName) // "file" is the name of the parameter
//                .when()
//                .get(endpoint)
//                .then()
//                .log().status()// validate status code
//                .header("Content-type",equalTo("application/json"))//validate header
//                .assertThat()
//                // getting cookies
//                .extract()
//                .cookies().toString(); // Extract all cookies as a string
//
////                .body("id", equalTo(1))
////                .body("firstName", equalTo("James"))
////                .body("lastName", equalTo("Smith"))
////                .body("email", equalTo("james_smith@anywhere.school"));
//                .body(
//                        "id",equalTo(3),
//                        "firstName",equalTo("James"),
//                        "lastName",equalTo("Smith"),
//                                "email",equalTo("james_smith@anywhere.school"));
//    }
@Test
        public void postDetails() {
            String endpoint = "http://localhost:8080/students";
            String body = """
                {
                
                    "firstName": "Shi1v",
                    "lastName": "Kan1t",
                    "email": "james_smi1th@anywhere.school"
                }
                """;

            // Make the POST request and validate the response
            given()
                    .header("Content-Type", "application/json") // Set the Content-Type
//                    .pathParam("id",42)

                    .body(body) // Set the request body
                    .when()
                    .post(endpoint) // Make the POST request
                    .then()
                    .statusCode(200) // Validate the response status code
//                    .body("id", equalTo(13)) // Validate the response body
                    .body("firstName", equalTo("Shi1v"))
                    .body("lastName", equalTo("Kan1t"))
                    .body("email", equalTo("james_smi1th@anywhere.school"))
                    .log().body(); // Log all details for debugging
        }
    @Test
    public void createStudentFromFile() {
        String endpoint = "http://localhost:8080/students";

        // Step 1: Define the JSON file
        File jsonFile = new File("src/test/java/restAssured/Student/Student/Student.json"); // Replace with the actual file path

        // Step 2: Make the POST request using the JSON file
        given()
                .header("Content-Type", "application/json") // Set the Content-Type
                .body(jsonFile) // Use the JSON file as the request body
                .when()
                .post(endpoint) // Make the POST request
                .then()
                .statusCode(200) // Validate the response status code
                .body("firstName", equalTo("Shiv")) // Validate the response body
                .body("lastName", equalTo("Kant"))
                .body("email", equalTo("james_smith@anywhere.school"))
                .log().all(); // Log all details for debugging
    }
    @Test
    public void validateStudentSchema() {
        // Define the endpoint
        String endpoint = "http://localhost:8080/students/1"; // Example endpoint

        // Define the JSON schema file
        File jsonSchema = new File("target/classes/student-schema.json"); // Replace with actual path

        // Perform the API request and validate the response against the JSON schema
        given()
                .header("Content-Type", "application/json") // Set the Content-Type
                .when()
                .get(endpoint) // Make the GET request
                .then()
//                .statusCode(200) // Validate the response status code
//                .assertThat() .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("student-schema.json")) ;// Validate against schema
                .log().all(); // Log details for debugging
    }
//    @Test
//    public void postDetailsDynamic() throws JsonProcessingException {
//        String endpoint = "http://localhost:8080/students/1";
//
//        // Create a Map to hold the student details dynamically
//        Map<String, String> studentDetails = new HashMap<>();
//        studentDetails.put("firstName", "Golu");
//        studentDetails.put("lastName", "Kumar");
//        studentDetails.put("email", "golu@epam.school");
//
//        // Convert the Map to JSON using Jackson ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();
//        String body = objectMapper.writeValueAsString(studentDetails);
//
//        // Make the PATCH request and validate the response
//        given()
//                .header("Content-Type", "application/json") // Set the Content-Type
////                .pathParam("id", 1) // Include the path parameter
//                .body(body) // Set the request body
//                .when()
//                .patch(endpoint) // Make the PATCH request
//                .then()
//                .log().status() // Log the status code
//                .log().headers() // Log the headers
//                .log().body() // Log the response body
//                .statusCode(200); // Validate the response status code
//    }
@Test
    public void patchSimple(){
     String endpoint="http://localhost:8080/students/1";
     String body= """
             {
                
                 "firstName": "Golu",
                 "lastName": "Sharma",
                 "email": "Golu@anywhere.school"
             }
             """;
     given().header("Content-Type","application/json")
             .body(body)
             .when()
             .put(endpoint)
             .then()
             .log().status()
             .statusCode(200)
             .log().body();

    }
    @Test
    public void simpleDelete(){
        String endpoint="http://localhost:8080/students/2";
//        String body= """
//                {
//                "id":2
//                }
//                """;
        given()
                .header("Content-type","application/json")
//                .body(body)
                .when()
                .delete(endpoint)
                .then()
                .log().status().log().body();


    }
    @Test
    public void serializePost(){
        String endpoint="http://localhost:8080/students";
        Student body=new Student(1,"Solu","sharma","a@gmail.com");
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().body();
    }
    @Test
    public void serializePut(){
        String endpoint="http://localhost:8080/students";
        Student body=new Student();
        body.setLastName("Kant");
        given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().body();
    }
    @Test
    public void desriliazeGet(){
        String endpoint="http://localhost:8080/students/1";
        Student deseriliaze=given()
                .when()
                .get(endpoint)
                .then()
//                .statusCode(200)
                .extract()
                .as(Student.class);
        System.out.println(deseriliaze.getId());
        System.out.println(deseriliaze.getFirstName());
        System.out.println(deseriliaze.getLastName());
        System.out.println(deseriliaze.getEmail());
    }
}


