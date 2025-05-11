package com.thetestingacademy;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Example_3 {
    public static void main(String[] args) {

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
