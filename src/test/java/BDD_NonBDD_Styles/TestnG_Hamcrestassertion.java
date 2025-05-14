package BDD_NonBDD_Styles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestnG_Hamcrestassertion {

    RequestSpecification r;
    Response res;
    ValidatableResponse vr;

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    @Test
    public void post_Resuest() {
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("auth");
        r.body(payload);
        r.header("Content-Type", "application/json");
        r.log().all();

        res = r.when().post();

        vr = res.then().log().all().statusCode(200);
        String b = vr.extract().response().toString();

        JsonPath st = new JsonPath(b);
        String token = st.getString("token");


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + 2);
        r.body("{\n" +
                "    \"firstname\" : \"Tejas\",\n" +
                "    \"lastname\" : \"Vishwa\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");
        r.cookie("token", token);
        r.header("Content-Type", "application/json");

        res = r.when().put();

        vr = res.then().log().all();

        vr.body("booking.firstname", Matchers.equalTo("Tejas"));


    }

}
