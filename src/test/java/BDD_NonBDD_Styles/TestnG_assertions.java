package BDD_NonBDD_Styles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestnG_assertions {


    RequestSpecification r;
    Response  res;
    ValidatableResponse vr;

    @Test
    public void post()
    {
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.header("Content-Type","application/json");
        r.body("{\n" +
                "    \"firstname\" : \"Tejas\",\n" +
                "    \"lastname\" : \"Vishwanath\",\n" +
                "    \"totalprice\" : 115,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");
        res= r.when().post();
        vr= res.then().log().all().statusCode(200);


        vr.body("booking.firstname", Matchers.equalTo("Tejas"));
        vr.body("booking.lastname",Matchers.equalTo("Vishwanath"));


        String firstname=res.then().extract().path("booking.firstname");
        String lastname=res.then().extract().path("booking.lastname");
        int bookingID=res.then().extract().path("bookingid");

        // TestNG Hard Assertions
        Assert.assertEquals(firstname,"Tejas");
        Assert.assertEquals(lastname,"Vishwanath");
        Assert.assertNotNull(bookingID);
    }

}
