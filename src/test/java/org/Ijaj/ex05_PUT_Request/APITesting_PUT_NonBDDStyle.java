package org.Ijaj.ex05_PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PUT_NonBDDStyle{
    @Description("CHECK PUT REQUEST")
    @Test
    public void test_put_NonBDD()
    {
        String token="242c5c8722eed99";
        String bookingid="5679";

        String Payload="{\n" +
                "    \"firstname\" : \"IJAJ\",\n" +
                "    \"lastname\" : \"SHAIKH\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r;
        Response response;
        ValidatableResponse vr;

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("Token"+token);
        r.body(Payload).log().all();


        response = r.when().put();

        //Verification Part 3
        vr = response.then().log().all();
        vr.statusCode(200);




    }
}
