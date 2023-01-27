package RestApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Post {
    public static void PostApiTest(){

        JSONObject request = new JSONObject();

        request.put("name", "İlker");
        request.put("job", "Senior Test Automation Development Engineer");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(request.toString())
                .log().method()
                .log().uri()
                .log().body()

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .assertThat().statusCode(201)
                .log().body();

    }
}
