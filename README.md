# ApiTest GET,POST,DELETE (https://reqres.in/)

<h3>pom.xml içerisine eklenmesi gereken dependencies</h3>

 ```javascript
 <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.2.1</version>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.3.0</version>
        </dependency>
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>
    </dependencies>
  ```

![](https://i.hizliresim.com/p2c03q9.png)

<h3>GetApiTest()</h3>

 ```javascript
 package RestApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
    public static void GetApiTest(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        //Http status code / (100 - 599) arasında dönen kod
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        //getBody All data get / Data'nın tamamını alır
        System.out.println(response.getBody().asString());
        //One data get / Tüm data içerisinden sadece first_name alır
        String first_name = response.jsonPath().getString("data.first_name");
        System.out.println(first_name);
        /*
         * Http status line / Bir Yanıt mesajının ilk satırı,
         * her öğenin SP karakterleriyle ayrıldığı sayısal bir durum
         * kodu ve bununla ilişkili metin cümlesinin takip ettiği protokol
         * versiyonundan oluşan Durum Satırıdır.
         */
        System.out.println(response.statusLine());

    }
}

  ```
<h3>GetApiTest() ->Run</h3>

![](https://i.hizliresim.com/jp2wfi5.png)


<h3>PostApiTest()</h3>

 ```javascript
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

  ```

<h3>PostApiTest() ->Run</h3>

![](https://i.hizliresim.com/5u690ac.png)


<h3>DeleteApiTest()</h3>

 ```javascript
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

  ```
