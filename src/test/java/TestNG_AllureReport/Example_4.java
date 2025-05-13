package TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Example_4 {
    String pincode ;

    @Test
    public void testCase1()
    {
         pincode= "560015";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
    @Test
    public void testCase2()
    {
        pincode= "@";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
    @Test
    public void testCase3()
    {
         pincode= "  ";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}
