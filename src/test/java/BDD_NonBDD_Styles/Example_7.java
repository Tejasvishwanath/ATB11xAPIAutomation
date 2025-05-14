package BDD_NonBDD_Styles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Example_7 {

    RequestSpecification r;   //used in given()
    Response res;      // used in when()
    ValidatableResponse vr;   //used in then()
    String pincode;

    @Test (groups = {"smoke","positive"})
    public void tc_Case01()
    {
        pincode="560015";
        //given()
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when

        res= r.when().log().all().get();
        System.out.println(res.asString());

        //then

        vr= res.then().log().all().statusCode(200);
    }

    @Test   (groups = {"negative"})
    public void tc_Case02()
    {
        pincode="@@";
        //given()
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when

        res= r.when().log().all().get();
        System.out.println(res.asString());

        //then

        vr= res.then().log().all().statusCode(404);
    }
    @Test   (groups = {"negative"})
    public void tc_Case03()
    {
        pincode="  ";
        //given()
        r= RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when

        res= r.when().log().all().get();
        System.out.println(res.asString());

        //then

        vr= res.then().log().all().statusCode(404);
    }
}
