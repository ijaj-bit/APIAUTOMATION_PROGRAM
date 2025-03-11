package org.Ijaj.ex03_Get_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_GET_BDD_STYLE_1 {

    @Test
    public void test_BDD_GET()
        {
            String pincode = "110048";

            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                    .when()
                    .get()
                    .then().log().all().statusCode(200);
        }
}
