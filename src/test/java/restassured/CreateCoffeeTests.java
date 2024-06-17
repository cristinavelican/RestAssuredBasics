package restassured;
import builders.CoffeeBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.Coffee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import support.SupportFunctions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
public class CreateCoffeeTests {

    static final String BASE_URL = "https://webservice.toscacloud.com/api/v1/Coffees";

    @Test
    void createCoffeeTest() {
        String jsonBody = "{\n" +
                "    \"id\": 23,\n" +
                "    \"description\": \"BEst coffee in the world\",\n" +
                "    \"name\": \"Cristina's coffee\"\n" +
                "}";
         RestAssured.given()
                .body(jsonBody)
                 .accept(ContentType.TEXT)
                 .contentType(ContentType.JSON)
                .post(BASE_URL)
                .then()
                .statusCode(200)
                 .body("name",equalTo("Cristina's coffee"))
                 .body(containsString("coffee"));
         ;
    }

    // refactor this test
    @Test
    void createCoffeeTestRefactor() throws JsonProcessingException {
        Coffee newCoffeeObject = CoffeeBuilder.createCoffeeObj(10, "Cristina's coffee","Best coffee in the city");
        String jsonBody = SupportFunctions.convertJavaObjectToJson(newCoffeeObject);
        System.out.println(jsonBody);
        RestAssured.given()
                 .body(jsonBody)
                .accept(ContentType.TEXT)
                .contentType(ContentType.JSON)
                .post(BASE_URL)
                .then()
                .statusCode(200)
                .body("name",equalTo("Cristina's coffee"))
                .body(containsString("coffee"));
    }

}
