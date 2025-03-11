package org.Ijaj.ex03_Get_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_GET_NONBDD_STYLE {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify The Get Req Positive")
    @Test
    public void test_NONBDD_GET_POSITIVE()
    {
        String pincode="560048";

        r  = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Description("Verify Get REQ Negative:-1 Input")
    @Test
    public void test_NONBDD_GET_NEGATIVE()
    {
        String pincode="-1";

        r  = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);

    }




}
