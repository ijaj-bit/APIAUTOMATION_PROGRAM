package org.Ijaj.ex01_RA_Basics;

import io.restassured.RestAssured;

public class APITesting005_MultipleTestCases {

    public static void main(String[] args) {


        String pincode = "110048";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

        pincode = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

        pincode = "";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}