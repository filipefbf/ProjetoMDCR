package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CusteioServiceTest {

    public static final Long ID = 1L;
    public static final String MUNICIPIO = "";
    public static final String NOME_PRODUTO = "";
    public static final String MES_EMISSAO = "";
    public static final String ANO_EMISSAO = "";
    public static final String CD_PROGRAMA = "";
    public static final String CD_SUB_PROGRAMA = "";
    public static final String CD_FONTE_RECURSO = "";
    public static final String CD_TIPO_SEGURO = "";
    public static final String CD_ESTADO = "";
    public static final double VL_CUSTEIO = 1.0;
    public static final String CD_PRODUTO = "";
    public static final String COD_CAD_MU = "";
    public static final String ATIVIDADE = "";
    public static final String CD_MODALIDADE = "";
    public static final String COD_IBGE = "";

    @InjectMocks
    private CusteioService service;

    @Mock
    private CusteioMunicipioRepository repository;

    private CusteioMunicipio custeioMunicipio;
    private Optional<CusteioMunicipio> OptionalCusteioMunicipio;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCusteio();
    }

//    @Test
//    void whenFindByIdThenReturnCusteioInstance() {
//        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(OptionalCusteioMunicipio);
//
//        Optional<CusteioMunicipio> response = service.findById(ID);
//
//        Assertions.assertEquals(CusteioMunicipio.class, response.getClass());
//    }

    @Test
    void listCusteio() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findPage() {
    }

    @Test
    void findFilter() {
    }

    private void startCusteio() {
        custeioMunicipio = new CusteioMunicipio(
                ID, MUNICIPIO, NOME_PRODUTO,
                MES_EMISSAO, ANO_EMISSAO, CD_PROGRAMA,
                CD_SUB_PROGRAMA, CD_FONTE_RECURSO, CD_TIPO_SEGURO,
                CD_ESTADO, VL_CUSTEIO, CD_PRODUTO, COD_CAD_MU,
                ATIVIDADE, CD_MODALIDADE, COD_IBGE, 0);
        OptionalCusteioMunicipio = Optional.of(new CusteioMunicipio(
                ID, MUNICIPIO, NOME_PRODUTO,
                MES_EMISSAO, ANO_EMISSAO, CD_PROGRAMA,
                CD_SUB_PROGRAMA, CD_FONTE_RECURSO, CD_TIPO_SEGURO,
                CD_ESTADO, VL_CUSTEIO, CD_PRODUTO, COD_CAD_MU,
                ATIVIDADE, CD_MODALIDADE, COD_IBGE, 0));
    }


//    ID, "", "",
//            "", "", "",
//            "", "", "",
//            "", 0.0, "", "",
//            "", "", "",0
}