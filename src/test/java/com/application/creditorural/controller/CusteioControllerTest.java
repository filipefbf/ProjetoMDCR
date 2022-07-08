package com.application.creditorural.controller;

import com.application.creditorural.Client.CusteioFeignClient;
import com.application.creditorural.DTO.DtoRoot;
import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.CusteioService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ConcurrentModel;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CusteioControllerTest {
    @Test
    void testGetAllPosts2() {

        DtoRoot dtoRoot = new DtoRoot();
        dtoRoot.setValue(new ArrayList<>());
        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(dtoRoot);
        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        assertSame(dtoRoot,
                (new CusteioController(modelMapper, repository, new CusteioService(), custeioFeignClient)).getAllPosts());
        verify(custeioFeignClient).getAllData();
    }

    @Test
    void testListCusteio2() {

        CusteioService custeioService = mock(CusteioService.class);
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioService.listCusteio((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualListCusteioResult = (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class))).listCusteio(null);
        assertSame(pageImpl, actualListCusteioResult);
        assertTrue(actualListCusteioResult.toList().isEmpty());
        verify(custeioService).listCusteio((Pageable) any());
    }

    @Test
    void testGetList2() {

        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));
        ModelAndView actualList = custeioController.getList(new ConcurrentModel(), null);
        assertTrue(actualList.isReference());
        Map<String, Object> model = actualList.getModel();
        assertSame(model, actualList.getModelMap());
        assertTrue(((PageImpl<Object>) model.get("custeioList")).toList().isEmpty());
        verify(custeioService).findAll((Pageable) any());
    }

    @Test
    void testSave2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));

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
        assertSame(custeioMunicipio, custeioController.save(custeioMunicipio1));
        verify(custeioService).save((CusteioMunicipio) any());
    }

    @Test
    void testFindByIdd2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findByIdd((Long) any())).thenReturn(custeioMunicipio);
        assertSame(custeioMunicipio, (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class),
                custeioService, mock(CusteioFeignClient.class))).findByIdd(123L));
        verify(custeioService).findByIdd((Long) any());
    }

    @Test
    void testRemove2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).deleteById((Long) any());
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class), custeioService,
                mock(CusteioFeignClient.class))).remove(123L);
        verify(custeioService).findById(anyLong());
        verify(custeioService).deleteById((Long) any());
    }

    @Test
    void testSerchByAno() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        ModelMapper modelMapper = new ModelMapper();
        ResponseEntity<Page<CusteioMunicipio>> actualSerchByAnoResult = (new CusteioController(modelMapper,
                custeioMunicipioRepository, new CusteioService(), mock(CusteioFeignClient.class))).serchByAno("foo", null);
        assertTrue(actualSerchByAnoResult.hasBody());
        assertTrue(actualSerchByAnoResult.getBody().toList().isEmpty());
        assertEquals(HttpStatus.OK, actualSerchByAnoResult.getStatusCode());
        assertTrue(actualSerchByAnoResult.getHeaders().isEmpty());
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testSerchByAno2() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.searchAno((String) any(), (Pageable) any()))
                .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        ModelMapper modelMapper = new ModelMapper();
        assertThrows(ResponseStatusException.class, () -> (new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class))).serchByAno("foo", null));
        verify(custeioMunicipioRepository).searchAno((String) any(), (Pageable) any());
    }

    @Test
    void testListAll() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(new ArrayList<>());
        ModelMapper modelMapper = new ModelMapper();
        assertTrue((new CusteioController(modelMapper, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class))).listAll().isEmpty());
        verify(custeioMunicipioRepository).findAll();
    }

    @Test
    void testToFilterDto() {

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        CusteioController custeioController = new CusteioController(modelMapper, repository, new CusteioService(),
                mock(CusteioFeignClient.class));

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
        FilterDto actualToFilterDtoResult = custeioController.toFilterDto(custeioMunicipio);
        assertEquals("Ano Emissao", actualToFilterDtoResult.getAnoEmissao());
        assertEquals(10.0d, actualToFilterDtoResult.getVlCusteio());
        assertEquals("SOJA", actualToFilterDtoResult.getNomeProduto());
        assertEquals("Municipio", actualToFilterDtoResult.getMunicipio());
        assertEquals(123L, actualToFilterDtoResult.getId().longValue());
        assertEquals("Cod Cad Mu", actualToFilterDtoResult.getCodCadMu());
        assertEquals("SOJA", actualToFilterDtoResult.getCdProduto());
    }

    @Test
    void testGetListFilter() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(new ArrayList<>());
        ModelMapper modelMapper = new ModelMapper();
        CusteioController custeioController = new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class));
        ModelAndView actualListFilter = custeioController.getListFilter(new ConcurrentModel(), null);
        assertTrue(actualListFilter.isReference());
        assertSame(actualListFilter.getModel(), actualListFilter.getModelMap());
        verify(custeioMunicipioRepository).findAll();
    }
    @Test
    void testFindFilter2() {

        CusteioService custeioService = mock(CusteioService.class);
        ArrayList<FilterConverter> filterConverterList = new ArrayList<>();
        when(custeioService.findFilter((String) any())).thenReturn(filterConverterList);
        List<FilterConverter> actualFindFilterResult = (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class)))
                .findFilter("Ano Emissao");
        assertSame(filterConverterList, actualFindFilterResult);
        assertTrue(actualFindFilterResult.isEmpty());
        verify(custeioService).findFilter((String) any());
    }
}