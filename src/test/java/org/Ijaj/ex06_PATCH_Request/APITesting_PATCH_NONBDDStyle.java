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
        String token="b09cd79b9844ec7";
        String bookingid="1199";

        String Payload="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("Token"+token);
        r.body(Payload).log().all();


        response = r.when().log().all().patch();

        //Verification Part 3
        vr = response.then().log().all();
        vr.statusCode(200);




    }

}
