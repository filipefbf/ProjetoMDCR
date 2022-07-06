package com.application.creditorural.DTO;

import com.application.creditorural.entities.CusteioMunicipio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterDtoTest {

    /**
     * Method under test: {@link FilterDto#FilterDto(CusteioMunicipio)}
     */
    @Test
    void testConstructor() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("alice.liddell@example.org");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio.setVlCusteio(10.0d);
        FilterDto actualFilterDto = new FilterDto(custeioMunicipio);
        assertEquals("Ano Emissao", actualFilterDto.getAnoEmissao());
        assertEquals(10.0d, actualFilterDto.getVlCusteio());
        assertEquals("alice.liddell@example.org", actualFilterDto.getNomeProduto());
        assertEquals("Municipio", actualFilterDto.getMunicipio());
        assertEquals(123L, actualFilterDto.getId().longValue());
        assertEquals("Cod Cad Mu", actualFilterDto.getCodCadMu());
        assertEquals("alice.liddell@example.org", actualFilterDto.getCdProduto());
    }

}