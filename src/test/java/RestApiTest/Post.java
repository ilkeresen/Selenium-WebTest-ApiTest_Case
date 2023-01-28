package RestApiTest;

import com.sun.xml.fastinfoset.util.StringArray;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static JsonOperations.ApiJson.GetApiJson;
import static JsonOperations.FileJson.GetFileJson;

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

    public static void PostApiTestFile(String UserName) throws IOException, ParseException {

        JSONObject request = new JSONObject();
        JSONObject user = (JSONObject) GetFileJson(UserName);

        request.put("name", user.get("name"));
        request.put("job", user.get("job"));

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

    public static void PostApiTestJson(){

        JSONObject request = new JSONObject();

        StringArray users = GetApiJson();

        request.put("name", users.get(0));
        request.put("job", users.get(1));

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
