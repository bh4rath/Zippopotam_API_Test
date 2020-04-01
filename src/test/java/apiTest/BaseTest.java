package apiTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static RequestSpecification requestSpec;

    @BeforeTest
    public static void createRequestSpecification(){
        requestSpec = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us")
                .build();
    }
}
