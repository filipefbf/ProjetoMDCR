package com.application.creditorural.controller;

import com.application.creditorural.Client.CusteioFeignClient;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.CusteioService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;


@WebMvcTest
public class CusteioControllerTest {
    @Autowired
    private CusteioController custeioController;
    @Autowired
    private CusteioMunicipioRepository repository;
    @Autowired
    private CusteioFeignClient feignClient;

    @MockBean
    private CusteioService custeioService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.custeioController);
    }



    @Test
    public void deveRetornarSucesso_QuandoBuscarId() {

        when(this.custeioService.findById(1L))
                .thenReturn(Optional.of(new CusteioMunicipio(
                        1L, "ABADIÂNIA", "BOVINOS", "05", "2018", "0999",
                        "0", "0503", "24615", "0.1", 0,
                        "", "", "", "", "", 1)));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/list/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}