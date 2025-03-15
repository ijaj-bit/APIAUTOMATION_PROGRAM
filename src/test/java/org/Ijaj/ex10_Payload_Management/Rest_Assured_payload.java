package org.Ijaj.ex10_Payload_Management;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import java.util.LinkedHashMap;
import java.util.Map;

public class Rest_Assured_payload {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    String token;
    Integer bookingId;

    @Test
    public void POST() {
//        String paloadPost = "{\n" +
//                "    \"firstname\" : \"Jim\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 5501,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"5000-01-01\",\n" +
//                "        \"checkout\" : \"5001-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";Insted of using this

        Map<String,Object> jasonBodyMap = new LinkedHashMap<String,Object>();
        jasonBodyMap.put("firstname","Jim");
        jasonBodyMap.put("lastname","Brown");
        jasonBodyMap.put("totalprice","5501");
        jasonBodyMap.put("depositpaid",true);

        Map<String,Object> jasonDateMap = new LinkedHashMap<>();
        jasonDateMap.put("checkin","5000-01-01");
        jasonDateMap.put("checkout","5001-01-01");
        jasonDateMap.put("additionalneeds","Breakfast");
        jasonBodyMap.put("bookingdates",jasonDateMap);

        System.out.println(jasonBodyMap);



    }
}
