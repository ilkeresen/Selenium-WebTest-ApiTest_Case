package JsonOperations;

import com.sun.xml.fastinfoset.util.StringArray;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.concurrent.ThreadLocalRandom;

public class ApiJson {
    public static StringArray GetApiJson(){

        int randomNumber = ThreadLocalRandom.current().nextInt(1, 12);

        Response response = RestAssured.get("https://reqres.in/api/users/"+randomNumber);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        String first_name = response.jsonPath().getString("data.first_name");
        String last_name = response.jsonPath().getString("data.last_name");
        StringArray users = new StringArray();
        users.add(first_name);
        users.add(last_name);

        return users;

    }
}
