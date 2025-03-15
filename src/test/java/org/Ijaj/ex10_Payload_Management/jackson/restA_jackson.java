package org.Ijaj.ex10_Payload_Management.jackson;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class restA_jackson {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    @Test
    public void test_create_booking_Positive() throws JsonProcessingException {
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
        ObjectMapper objectMapper = new ObjectMapper();

        String jasonStringBooking = objectMapper.writeValueAsString(booking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jasonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jasonresponseString = response.asString();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

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


        BookingResponse bookingResponse = null;

        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Jim");

    }

    }


