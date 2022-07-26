package com.application.creditorural.services;

import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CusteioServiceTest {

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private CusteioMunicipioRepository custeioMunicipioRepository;

    @Autowired
    private CusteioService custeioService;

    @InjectMocks
    private CusteioService service;
    @Mock
    private CusteioMunicipioRepository repository;
    private CusteioMunicipio custeioMunicipio;
    private Optional<CusteioMunicipio> municipioOpitional;

    @Test
    void testListCusteio() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualListCusteioResult = custeioService.listCusteio(null);
        assertSame(pageImpl, actualListCusteioResult);
        assertTrue(actualListCusteioResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    @Test
    void testSave() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("SOJA");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("SOJA");
        custeioMunicipio.setVlCusteio(10.0d);
        when(custeioMunicipioRepository.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("Ano Emissao");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("Atividade");
        custeioMunicipio1.setCdEstado("Cd Estado");
        custeioMunicipio1.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio1.setCdModalidade("Cd Modalidade");
        custeioMunicipio1.setCdProduto("SOJA");
        custeioMunicipio1.setCdPrograma("Cd Programa");
        custeioMunicipio1.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio1.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio1.setCodCadMu("Cod Cad Mu");
        custeioMunicipio1.setCodIbge("Cod Ibge");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("Mes Emissao");
        custeioMunicipio1.setMunicipio("Municipio");
        custeioMunicipio1.setNomeProduto("SOJA");
        custeioMunicipio1.setVlCusteio(10.0d);
        assertSame(custeioMunicipio, custeioService.save(custeioMunicipio1));
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
    }

    @Test
    void testAddNew() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("SOJA");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("SOJA");
        custeioMunicipio.setVlCusteio(10.0d);
        when(custeioMunicipioRepository.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("Ano Emissao");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("Atividade");
        custeioMunicipio1.setCdEstado("Cd Estado");
        custeioMunicipio1.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio1.setCdModalidade("Cd Modalidade");
        custeioMunicipio1.setCdProduto("SOJA");
        custeioMunicipio1.setCdPrograma("Cd Programa");
        custeioMunicipio1.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio1.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio1.setCodCadMu("Cod Cad Mu");
        custeioMunicipio1.setCodIbge("Cod Ibge");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("Mes Emissao");
        custeioMunicipio1.setMunicipio("Municipio");
        custeioMunicipio1.setNomeProduto("SOJA");
        custeioMunicipio1.setVlCusteio(10.0d);
        custeioService.AddNew(custeioMunicipio1);
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
        assertEquals("Ano Emissao", custeioMunicipio1.getAnoEmissao());
        assertEquals(10.0d, custeioMunicipio1.getVlCusteio().doubleValue());
        assertEquals("SOJA", custeioMunicipio1.getNomeProduto());
        assertEquals("Municipio", custeioMunicipio1.getMunicipio());
        assertEquals("Mes Emissao", custeioMunicipio1.getMesEmissao());
        assertEquals(123L, custeioMunicipio1.getId());
        assertEquals("Cod Ibge", custeioMunicipio1.getCodIbge());
        assertEquals("Cod Cad Mu", custeioMunicipio1.getCodCadMu());
        assertEquals("Cd Tipo Seguro", custeioMunicipio1.getCdTipoSeguro());
        assertEquals("Cd Sub Programa", custeioMunicipio1.getCdSubPrograma());
        assertEquals("Cd Programa", custeioMunicipio1.getCdPrograma());
        assertEquals("SOJA", custeioMunicipio1.getCdProduto());
        assertEquals("Cd Modalidade", custeioMunicipio1.getCdModalidade());
        assertEquals("Cd Fonte Recurso", custeioMunicipio1.getCdFonteRecurso());
        assertEquals("Cd Estado", custeioMunicipio1.getCdEstado());
        assertEquals("Atividade", custeioMunicipio1.getAtividade());
        assertEquals(1, custeioMunicipio1.getAreaCusteio().intValue());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCusteio();

        PageImpl<CusteioMunicipio> custeioPage = new PageImpl<>(List.of());
    }

    @Test
    void testFindById() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("SOJA");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("SOJA");
        custeioMunicipio.setVlCusteio(10.0d);
        Optional<CusteioMunicipio> ofResult = Optional.of(custeioMunicipio);
        when(custeioMunicipioRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<CusteioMunicipio> actualFindByIdResult = custeioService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(custeioMunicipioRepository).findById((Long) any());
    }

    @Test
    void whenfindByIdThenReturnAnNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(municipioOpitional);

        Optional<CusteioMunicipio> response = service.findById(1L);

        assertNotNull(response);
        //Assertions.assertEquals(municipioOpitional, response.get());
        //Assertions.assertEquals(1L, response.getId());
    }

    @Test
    void testFindByIdd() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("SOJA");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("SOJA");
        custeioMunicipio.setVlCusteio(10.0d);
        Optional<CusteioMunicipio> ofResult = Optional.of(custeioMunicipio);
        when(custeioMunicipioRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(custeioMunicipio, custeioService.findByIdd(123L));
        verify(custeioMunicipioRepository).findById((Long) any());
    }

    @Test
    void testFindByIdd2() {
        when(custeioMunicipioRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> custeioService.findByIdd(123L));
        verify(custeioMunicipioRepository).findById((Long) any());
    }

    @Test
    void testDeleteById() {
        doNothing().when(custeioMunicipioRepository).deleteById((Long) any());
        custeioService.deleteById(123L);
        verify(custeioMunicipioRepository).deleteById((Long) any());
    }

    @Test
    void testFindAll() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualFindAllResult = custeioService.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    @Test
    void testFindPage() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualFindPageResult = custeioService.findPage(10);
        assertSame(pageImpl, actualFindPageResult);
        assertTrue(actualFindPageResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    @Test
    void testFindFilter() {
        ArrayList<FilterConverter> filterConverterList = new ArrayList<>();
        when(custeioMunicipioRepository.searchYearFilter((String) any())).thenReturn(filterConverterList);
        List<FilterConverter> actualFindFilterResult = custeioService.findFilter("Ano Emissao");
        assertSame(filterConverterList, actualFindFilterResult);
        assertTrue(actualFindFilterResult.isEmpty());
        verify(custeioMunicipioRepository).searchYearFilter((String) any());
    }

    @Test
    void testUpdate() {
        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("Ano Emissao");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("Atividade");
        custeioMunicipio.setCdEstado("Cd Estado");
        custeioMunicipio.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio.setCdModalidade("Cd Modalidade");
        custeioMunicipio.setCdProduto("SOJA");
        custeioMunicipio.setCdPrograma("Cd Programa");
        custeioMunicipio.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio.setCodCadMu("Cod Cad Mu");
        custeioMunicipio.setCodIbge("Cod Ibge");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("Mes Emissao");
        custeioMunicipio.setMunicipio("Municipio");
        custeioMunicipio.setNomeProduto("SOJA");
        custeioMunicipio.setVlCusteio(10.0d);
        when(custeioMunicipioRepository.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("Ano Emissao");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("Atividade");
        custeioMunicipio1.setCdEstado("Cd Estado");
        custeioMunicipio1.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio1.setCdModalidade("Cd Modalidade");
        custeioMunicipio1.setCdProduto("SOJA");
        custeioMunicipio1.setCdPrograma("Cd Programa");
        custeioMunicipio1.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio1.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio1.setCodCadMu("Cod Cad Mu");
        custeioMunicipio1.setCodIbge("Cod Ibge");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("Mes Emissao");
        custeioMunicipio1.setMunicipio("Municipio");
        custeioMunicipio1.setNomeProduto("SOJA");
        custeioMunicipio1.setVlCusteio(10.0d);
        custeioService.update(custeioMunicipio1);
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
        assertEquals("Ano Emissao", custeioMunicipio1.getAnoEmissao());
        assertEquals(10.0d, custeioMunicipio1.getVlCusteio().doubleValue());
        assertEquals("SOJA", custeioMunicipio1.getNomeProduto());
        assertEquals("Municipio", custeioMunicipio1.getMunicipio());
        assertEquals("Mes Emissao", custeioMunicipio1.getMesEmissao());
        assertEquals(123L, custeioMunicipio1.getId());
        assertEquals("Cod Ibge", custeioMunicipio1.getCodIbge());
        assertEquals("Cod Cad Mu", custeioMunicipio1.getCodCadMu());
        assertEquals("Cd Tipo Seguro", custeioMunicipio1.getCdTipoSeguro());
        assertEquals("Cd Sub Programa", custeioMunicipio1.getCdSubPrograma());
        assertEquals("Cd Programa", custeioMunicipio1.getCdPrograma());
        assertEquals("SOJA", custeioMunicipio1.getCdProduto());
        assertEquals("Cd Modalidade", custeioMunicipio1.getCdModalidade());
        assertEquals("Cd Fonte Recurso", custeioMunicipio1.getCdFonteRecurso());
        assertEquals("Cd Estado", custeioMunicipio1.getCdEstado());
        assertEquals("Atividade", custeioMunicipio1.getAtividade());
        assertEquals(1, custeioMunicipio1.getAreaCusteio().intValue());
    }

    @Test
    void testToFilterDto() {
        FilterDto filterDto = new FilterDto();
        when(modelMapper.map((Object) any(), (Class<FilterDto>) any())).thenReturn(filterDto);

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
        assertSame(filterDto, custeioService.toFilterDto(custeioMunicipio));
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
    }

    @Test
    void testToFilterDto2() {
        when(modelMapper.map((Object) any(), (Class<FilterDto>) any()))
                .thenThrow(new RuntimeException("An error occurred"));

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
        assertThrows(RuntimeException.class, () -> custeioService.toFilterDto(custeioMunicipio));
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
    }

    @Test
    void testListAll() {
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(custeioService.listAll("Ano Emissao", null).isEmpty());
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testListAll2() {
        when(modelMapper.map((Object) any(), (Class<FilterDto>) any())).thenReturn(new FilterDto());

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

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio);
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(custeioMunicipioList);
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any())).thenReturn(pageImpl);
        assertEquals(1, custeioService.listAll("Ano Emissao", null).size());
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testSerchByAno() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualSerchByAnoResult = custeioService.serchByAno("Ano Emissao", null);
        assertSame(pageImpl, actualSerchByAnoResult);
        assertTrue(actualSerchByAnoResult.toList().isEmpty());
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testSerchByAno2() {
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any()))
                .thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> custeioService.serchByAno("Ano Emissao", null));
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testUpdateList() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

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
        Optional<CusteioMunicipio> ofResult = Optional.of(custeioMunicipio);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("Ano Emissao");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("Atividade");
        custeioMunicipio1.setCdEstado("Cd Estado");
        custeioMunicipio1.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio1.setCdModalidade("Cd Modalidade");
        custeioMunicipio1.setCdProduto("alice.liddell@example.org");
        custeioMunicipio1.setCdPrograma("Cd Programa");
        custeioMunicipio1.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio1.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio1.setCodCadMu("Cod Cad Mu");
        custeioMunicipio1.setCodIbge("Cod Ibge");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("Mes Emissao");
        custeioMunicipio1.setMunicipio("Municipio");
        custeioMunicipio1.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio1.setVlCusteio(10.0d);
        when(custeioMunicipioRepository.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio1);
        when(custeioMunicipioRepository.findById((Long) any())).thenReturn(ofResult);

        CusteioMunicipio custeioMunicipio2 = new CusteioMunicipio();
        custeioMunicipio2.setAnoEmissao("Ano Emissao");
        custeioMunicipio2.setAreaCusteio(1);
        custeioMunicipio2.setAtividade("Atividade");
        custeioMunicipio2.setCdEstado("Cd Estado");
        custeioMunicipio2.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio2.setCdModalidade("Cd Modalidade");
        custeioMunicipio2.setCdProduto("alice.liddell@example.org");
        custeioMunicipio2.setCdPrograma("Cd Programa");
        custeioMunicipio2.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio2.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio2.setCodCadMu("Cod Cad Mu");
        custeioMunicipio2.setCodIbge("Cod Ibge");
        custeioMunicipio2.setId(123L);
        custeioMunicipio2.setMesEmissao("Mes Emissao");
        custeioMunicipio2.setMunicipio("Municipio");
        custeioMunicipio2.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio2.setVlCusteio(10.0d);
        custeioService.updateList(custeioMunicipio2);
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
        verify(custeioMunicipioRepository).findById((Long) any());
    }

    @Test
    void testUpdateList2() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

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
        Optional<CusteioMunicipio> ofResult = Optional.of(custeioMunicipio);
        when(custeioMunicipioRepository.save((CusteioMunicipio) any()))
                .thenThrow(new RuntimeException("An error occurred"));
        when(custeioMunicipioRepository.findById((Long) any())).thenReturn(ofResult);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("Ano Emissao");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("Atividade");
        custeioMunicipio1.setCdEstado("Cd Estado");
        custeioMunicipio1.setCdFonteRecurso("Cd Fonte Recurso");
        custeioMunicipio1.setCdModalidade("Cd Modalidade");
        custeioMunicipio1.setCdProduto("alice.liddell@example.org");
        custeioMunicipio1.setCdPrograma("Cd Programa");
        custeioMunicipio1.setCdSubPrograma("Cd Sub Programa");
        custeioMunicipio1.setCdTipoSeguro("Cd Tipo Seguro");
        custeioMunicipio1.setCodCadMu("Cod Cad Mu");
        custeioMunicipio1.setCodIbge("Cod Ibge");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("Mes Emissao");
        custeioMunicipio1.setMunicipio("Municipio");
        custeioMunicipio1.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio1.setVlCusteio(10.0d);
        assertThrows(RuntimeException.class, () -> custeioService.updateList(custeioMunicipio1));
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
        verify(custeioMunicipioRepository).findById((Long) any());
    }

    @Test
    void whenfindAllThenReturnListCusteio() {
        PageRequest paginacao = PageRequest.of(0, 10);
        List<CusteioMunicipio> response = Arrays.asList(new CusteioMunicipio(), new CusteioMunicipio());
        Page<CusteioMunicipio> responsePage = new PageImpl<>(response, paginacao, response.size());


        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(CusteioMunicipio.class, response.get(0).getClass());

        assertEquals(0, response.get(0).getId());
    }

    private void startCusteio() {
        custeioMunicipio = new CusteioMunicipio(1, "RIO VERDE DE MATO GROSSO", "BOVINOS", "05", "2015", "0999", "0", "0300", "-1", "13", 574.57, "1300", "38986", "2", "26", "500", 0);
        municipioOpitional = Optional.of(new CusteioMunicipio(1, "RIO VERDE DE MATO GROSSO", "BOVINOS", "05", "2015", "0999", "0", "0300", "-1", "13", 574.57, "1300", "38986", "2", "26", "500", 0));
    }
}