package apiTest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Chapter2Test extends BaseTest {
    @Test
    public void requestUsZipCode_checkStatusCode_expectHttp200(){
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void requestUsZipCode_checkContentType_expectApplicationJson(){
        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().assertThat().
                contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails(){
        given().
                spec(requestSpec).
                log().all().
                when().
                get("us/90210").
                then().
                log().body();
    }
}