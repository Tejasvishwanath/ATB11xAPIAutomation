package com.thetestingacademy;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Example_3 {
    @Test
    public static void tc1() {

       String pincode= "560015";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
         pincode= "@";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}
