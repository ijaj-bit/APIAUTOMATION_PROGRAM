package org.Ijaj.ex04_POST_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting_POST_BDDStyle {

    @Test
    public void test_Post_BDDStyle()
    {
        String Payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

         RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
        .basePath("/auth")
        .contentType(ContentType.JSON)
        .body(Payload).log().all();

    }
}
