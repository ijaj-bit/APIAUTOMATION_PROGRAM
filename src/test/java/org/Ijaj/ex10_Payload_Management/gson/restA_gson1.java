package org.Ijaj.ex10_Payload_Management.gson;
//gson - Google liebrary to your class to jason  and jason to class
//it is a plian text in key and value pait to trasfer from client server

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class restA_gson1 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    @Test
    public void test_create_booking_Positive()
    {
        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setDepositpaid(true);
        booking.setTotalprice(5501);

        Bookingdates bookingdates = new Bookingdates();

        bookingdates.setCheckin("5000-01-01");
        bookingdates.setCheckout("5001-01-01");
        booking.setAdditionalneeds("Breakfast");
        booking.setBookingdates(bookingdates);

        System.out.println(booking);
        //java object -> String
        Gson gson = new Gson();
        String jasonStringBooking = gson.toJson(booking);
        System.out.println(jasonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jasonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jasonresponseString = response.asString();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //case1 ->extract() -Direct Extraction

        String firtname = response.then().extract().path("booking.firstname");

        System.out.println(firtname);

        //TestNG
        Assert.assertEquals(firtname,"Jim");

        //AssertJ

        assertThat(firtname).isNotNull().isNotBlank().isNotEmpty().isEqualTo("Jim");

        //case2 ->Extraction()- jasonPath.getString();

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId =jsonPath.getString("Bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String lastname = jsonPath.getString("booking.lastname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(checkin);


        //Case 3 deSerialization - Extraction
        //Response -> deseriliaze into another response class

        String jasonresponseString1 = response.asString();
       BookingResponse bookingResponse= gson.fromJson(jasonresponseString1,BookingResponse.class);
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBooking()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim");
    }
}
