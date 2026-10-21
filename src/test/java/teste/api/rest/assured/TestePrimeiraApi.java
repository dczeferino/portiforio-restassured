package teste.api.rest.assured;

import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    @Test
    public void primeiraApi(){
        String url = "http://localhost:8080/api/primeiraApi";
        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!"));
    }

    @Test
    public void primeiraApiV1(){
        String url = "http://localhost:8080/api/primeiraApi";
        String valorParametro = "QA Senior";
        RestAssured.given()
                .queryParam("palavra", valorParametro)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!"));
    }


}
