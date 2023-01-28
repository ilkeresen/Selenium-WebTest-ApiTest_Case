package RestApiTest;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Put {
    public static void PutApiTest(){
        JSONObject request = new JSONObject();
        request.put("name", "İlker");
        request.put("job", "Junior Test Automation Development Specialist");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200)
                .log().all();
    }
}
