package org.Ijaj.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the Post Positive Request")
    @Test
   public  void test_POST_NonBDDStyle_Create_Token()
   {
       //URL/METHOD,Payload/Body/Headers
       //No Auth

       String Payload="{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";


       //Pre-Condition =Preparing Request -URLS , HEADERS,AUTH PART-1
       r = RestAssured.given();
       r.baseUri("https://restful-booker.herokuapp.com");
       r.basePath("/auth");
       r.contentType(ContentType.JSON);
       r.body(Payload).log().all();


        //Making HTTP Request Part2
       response = r.when().log().all().post();

       //Verification Part 3
       vr = response.then().log().all();
       vr.statusCode(200);

   }
}
