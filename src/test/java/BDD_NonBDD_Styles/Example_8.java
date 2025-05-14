package BDD_NonBDD_Styles;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Example_8 {

    RequestSpecification r;   //used in given()
    Response res;      // used in when()
    ValidatableResponse vr;   //used in then()




    @Test
    public void serverPing()
    {
        System.out.println("Server is up");
    }
    @Test (dependsOnMethods = "serverPing")
    public void scenario()
    {
        String pincode="  ";
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
