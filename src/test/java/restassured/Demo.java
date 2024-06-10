package restassured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class Demo {


    static final String BASE_URL = "https://webservice.toscacloud.com/api/training/Coffees/{token}";
    static final String AUTHENTICATION_TOKEN = "95938123-4c2e-ad9c-a329-6477d124eeb7";

    @Test
    public void getCoffees() {
        RestAssured.get(BASE_URL+AUTHENTICATION_TOKEN)
                .then()
                .statusCode(200);

    }

    @Test
    public void peekCoffees() {
        RestAssured.get(BASE_URL+AUTHENTICATION_TOKEN)
                .prettyPeek();

    }

    //specific response headers
    @Test
    public void headersCoffeesResponse() {
        Response response = RestAssured.get(BASE_URL+AUTHENTICATION_TOKEN);
        System.out.println(response.getHeader("Content-Type"));
    }

    //refactor -pathParam
    @Test
    public void pathParamCoffeesResponse() {
        Response response = RestAssured
                .given()
                .pathParam("token",AUTHENTICATION_TOKEN)
                .get(BASE_URL);
        System.out.println(response.getHeader("Content-Type"));
    }

    //refactor - query parameters
    @Test
    public void paramCoffeesResponse() {
        Response response = RestAssured
                .given()
                .pathParam("token",AUTHENTICATION_TOKEN)
                .param("per_page",1)
                .param("lang","en")
                .get(BASE_URL);
        System.out.println(response.getHeaders());
    }

    //Assertions
    @Test
    public void assertStatusCodeOKGetCoffeesResponse() {
        RestAssured
                .given()
                .pathParam("token",AUTHENTICATION_TOKEN)
                .get(BASE_URL)
                .then()
                .statusCode(lessThan(300))
                .header("Content-Type",containsStringIgnoringCase("application/json"))
                .contentType(ContentType.JSON)
                .header("Content-Encoding",notNullValue())
                .time(lessThan(2L), TimeUnit.SECONDS)
        ;
        ;

    }
}
