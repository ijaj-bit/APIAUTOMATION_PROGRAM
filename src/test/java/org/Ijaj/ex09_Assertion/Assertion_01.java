package org.Ijaj.ex09_Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class Assertion_01 {
    //Default Assertion


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    String token;
    Integer bookingId;

    @Test
    public void POST()
    {
        String paloadPost="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 5501,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"5000-01-01\",\n" +
                "        \"checkout\" : \"5001-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(paloadPost).log().all();

        response = requestSpecification.when().post();

        //get valitable response to perform validation
        validatableResponse = response.then().log().all();

        //RestAssured
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname",Matchers.equalTo("Jim") );
        validatableResponse.body("booking.lastname",Matchers.equalTo("Brown") );
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true) );
        validatableResponse.body("booking.bookingid",Matchers.notNullValue() );

    }
}
