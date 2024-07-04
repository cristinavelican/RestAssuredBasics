package restassured;
import builders.CoffeeBuilder;
import builders.NormalCoffeeBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.Coffee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import support.SupportFunctions;


import javax.crypto.spec.PSource;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

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
    //@Test
//    void createCoffeeTestRefactor() throws JsonProcessingException {
//        //Coffee newCoffeeObject = CoffeeBuilder.createCoffeeObj(10, "Cristina's coffee","Best coffee in the city");
//
//        NormalCoffeeBuilder builder = new NormalCoffeeBuilder();
//        Coffee newCoffeeObject = builder.setName("Cristina").setDescription("Cristina's coffee").setId(10).build();
//        String jsonBody = SupportFunctions.convertJavaObjectToJson(newCoffeeObject);
//        System.out.println("the coffee body is=");
//        System.out.println(jsonBody);
//        RestAssured.given()
//                 .body(jsonBody)
//                .accept(ContentType.TEXT)
//                .contentType(ContentType.JSON)
//                .post(BASE_URL)
//                .then()
//                .statusCode(200)
//                .body("name",equalTo("Cristina"))
//                .body(containsString("coffee"));
//    }

    // create a new test for PUT Coffees
    @Test
    void putCoffee()
    {
        NormalCoffeeBuilder builder = new NormalCoffeeBuilder();
        Coffee newCoffeeObject = builder.setId(4).setName("Monday Coffee").setDescription("Cristina's coffee").build();
        String jsonCoffee = "";
        try {
             jsonCoffee = SupportFunctions.convertJavaObjectToJson(newCoffeeObject);
        }
        catch(JsonProcessingException e) {
            System.out.println("There was a JSONProcessing Exception");
        }
        System.out.println("the body is:" + jsonCoffee);

        Response response =  RestAssured.given()
                .header("accept", "text/plain")
                .header("Content-Type", "application/json")
                .accept(ContentType.TEXT)
                .contentType(ContentType.JSON)
                .body(jsonCoffee)
                .when()
                .put(BASE_URL);

        RestAssured.given()
                .accept(ContentType.TEXT)
                .contentType(ContentType.JSON)
                .body(jsonCoffee)
                .when()
                .put(BASE_URL)
                .then()
                .statusCode(200)
                .body("name", equalTo("Monday Coffee"));

    }
}
