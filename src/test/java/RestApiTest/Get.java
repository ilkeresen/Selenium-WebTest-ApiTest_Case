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
