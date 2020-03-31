package apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Chapter4Test extends BaseTest{
    @Test
    public void requestUsZipCode90210_extractPlaceNameFromResponseBody_assertEqualToBeverlyHills(){
        String placeName =
                given().spec(requestSpec).
                        when().get("us/90210").
                        then().extract().
                        path("places[0].'place name'");
        Assert.assertEquals(placeName,"Beverly Hills");
    }
}
