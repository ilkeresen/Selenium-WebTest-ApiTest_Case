package RestApiTest;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Delete {
    public static void DeleteApiTest(){

        JSONObject request = new JSONObject();

        given().
                body(request.toJSONString()).
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().all();

    }
}
