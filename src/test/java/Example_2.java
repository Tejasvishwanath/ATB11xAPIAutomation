import io.restassured.RestAssured;
import java.util.Scanner;


public class Example_2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the pincode");
        String pincode= s.next();
        s.close();
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }
}
