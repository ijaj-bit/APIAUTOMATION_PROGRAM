package org.Ijaj.ex07_DELETE_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_DELETE_NONBDDSTYLE {
    @Description("Verify the delete request")
    @Test
    public void test_patch_NonBDD()
    {
        String token="b09cd79b9844ec7";
        String bookingid="1199";


        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("Token"+token);

        r.log().all();

        response = r.when().log().all().delete();

        //Verification Part 3
        vr = response.then().log().all();
        vr.statusCode(200);




    }

}
