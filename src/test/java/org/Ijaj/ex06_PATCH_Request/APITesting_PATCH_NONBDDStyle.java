package org.Ijaj.ex06_PATCH_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PATCH_NONBDDStyle {

    @Test
    public void test_patch_NonBDD()
    {
        String token="68d22fadfe4f4f4";
        String bookingid="8400";

        String payloadPATCH="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        //STEP 1
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);

        //STEP 2
        requestSpecification.cookie("Token"+token);
        requestSpecification.body(payloadPATCH).log().all();

        //STEP 3
        Response response  = requestSpecification.when().patch();

        //STEP 4
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);







    }

}
