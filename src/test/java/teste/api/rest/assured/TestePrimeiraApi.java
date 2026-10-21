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
        String valorParametro = "Segundo Teste";
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

    @Test
    public void primeiraApiV3(){
        //Deve retornar se o numero é par ou impar
        //Teste realizado para retorna o valor impar
        String url = "http://localhost:8080/exercicios/parOuImpar";
        String valorParametro = "3";
        String retorno = "O numero " +valorParametro+ " é impar";
        RestAssured.given()
                .queryParam("numero", valorParametro)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(retorno));
    }

    @Test
    public void primeiraApiV4(){
        //Deve retornar se o numero é par ou impar
        //Teste realizado para retorna o valor par
        String url = "http://localhost:8080/exercicios/parOuImpar";
        String valorParametro = "4";
        String retorno = "O numero " +valorParametro+ " é par";
        RestAssured.given()
                .queryParam("numero", valorParametro)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(retorno));
    }

    @Test
    public void primeiraApiV5(){
        //Deve retornar se o numero é par ou impar
        //Teste realizado para retorna o valor par
        String valorParametro = "4000";
        String url = "http://localhost:8080/exercicios/calculaSalario/"+valorParametro;
        String retorno = "Salario liquido = "+valorParametro;
        RestAssured.given()
                .queryParam(valorParametro)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(""));
    }

}
