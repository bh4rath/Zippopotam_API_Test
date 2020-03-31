package apiTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Chapter1Test extends BaseTest {
    @Test
    public void requestUsZipCode_checkPlaceNameInResponseBody_expectBeverlyHills(){
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills(){
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode_checkListOfPlaceNamesInResponseBody_expectOne(){
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().assertThat().
                body("places.'place name'", hasSize(1));
    }
}