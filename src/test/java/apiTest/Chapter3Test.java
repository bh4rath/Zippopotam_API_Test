package apiTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter3Test extends BaseTest {
    @DataProvider(name = "providecountrydata")
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }

    @Test(dataProvider = "providecountrydata")
    public void requestZipCodesFromCollection(String countryCode, String zipCode, String expectedPlaceName){
        given().
                spec(requestSpec).
                pathParam("countryCode",countryCode).pathParam("zipCode", zipCode).
                when().
                get("{countryCode}/{zipCode}").
                then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
        System.out.println("country code is " + countryCode + "zipcode is " + zipCode + "place name is" + expectedPlaceName);
    }
}