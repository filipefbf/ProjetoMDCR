package com.application.creditorural.controller;

import com.application.creditorural.Client.CusteioFeignClient;
import com.application.creditorural.DTO.DtoRoot;
import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.DTO.ListDto;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
    void testUpdateList2() {

        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).updateList((CusteioMunicipio) any());
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));

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
        custeioController.updateList(123L, custeioMunicipio);
        verify(custeioService).updateList((CusteioMunicipio) any());
        assertEquals(123L, custeioMunicipio.getId());
    }

    @Test
    void testUpdateList3() {


        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).updateList((CusteioMunicipio) any());
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));
        CusteioMunicipio custeioMunicipio = mock(CusteioMunicipio.class);
        doNothing().when(custeioMunicipio).setAnoEmissao((String) any());
        doNothing().when(custeioMunicipio).setAreaCusteio((Integer) any());
        doNothing().when(custeioMunicipio).setAtividade((String) any());
        doNothing().when(custeioMunicipio).setCdEstado((String) any());
        doNothing().when(custeioMunicipio).setCdFonteRecurso((String) any());
        doNothing().when(custeioMunicipio).setCdModalidade((String) any());
        doNothing().when(custeioMunicipio).setCdProduto((String) any());
        doNothing().when(custeioMunicipio).setCdPrograma((String) any());
        doNothing().when(custeioMunicipio).setCdSubPrograma((String) any());
        doNothing().when(custeioMunicipio).setCdTipoSeguro((String) any());
        doNothing().when(custeioMunicipio).setCodCadMu((String) any());
        doNothing().when(custeioMunicipio).setCodIbge((String) any());
        doNothing().when(custeioMunicipio).setId(anyLong());
        doNothing().when(custeioMunicipio).setMesEmissao((String) any());
        doNothing().when(custeioMunicipio).setMunicipio((String) any());
        doNothing().when(custeioMunicipio).setNomeProduto((String) any());
        doNothing().when(custeioMunicipio).setVlCusteio((Double) any());
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
        custeioController.updateList(123L, custeioMunicipio);
        verify(custeioService).updateList((CusteioMunicipio) any());
        verify(custeioMunicipio).setAnoEmissao((String) any());
        verify(custeioMunicipio).setAreaCusteio((Integer) any());
        verify(custeioMunicipio).setAtividade((String) any());
        verify(custeioMunicipio).setCdEstado((String) any());
        verify(custeioMunicipio).setCdFonteRecurso((String) any());
        verify(custeioMunicipio).setCdModalidade((String) any());
        verify(custeioMunicipio).setCdProduto((String) any());
        verify(custeioMunicipio).setCdPrograma((String) any());
        verify(custeioMunicipio).setCdSubPrograma((String) any());
        verify(custeioMunicipio).setCdTipoSeguro((String) any());
        verify(custeioMunicipio).setCodCadMu((String) any());
        verify(custeioMunicipio).setCodIbge((String) any());
        verify(custeioMunicipio, atLeast(1)).setId(anyLong());
        verify(custeioMunicipio).setMesEmissao((String) any());
        verify(custeioMunicipio).setMunicipio((String) any());
        verify(custeioMunicipio).setNomeProduto((String) any());
        verify(custeioMunicipio).setVlCusteio((Double) any());
    }


    @Test
    void testSerchByAno2() {


        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.serchByAno((String) any(), (Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        ResponseEntity<Page<CusteioMunicipio>> actualSerchByAnoResult = (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class)))
                .serchByAno("Ano Emissao", null);
        assertTrue(actualSerchByAnoResult.hasBody());
        assertTrue(actualSerchByAnoResult.getBody().toList().isEmpty());
        assertEquals(HttpStatus.OK, actualSerchByAnoResult.getStatusCode());
        assertTrue(actualSerchByAnoResult.getHeaders().isEmpty());
        verify(custeioService).serchByAno((String) any(), (Pageable) any());
    }


    @Test
    void testListAll2() {


        CusteioService custeioService = mock(CusteioService.class);
        ArrayList<FilterDto> filterDtoList = new ArrayList<>();
        when(custeioService.listAll((String) any(), (Pageable) any())).thenReturn(filterDtoList);
        List<FilterDto> actualListAllResult = (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class))).listAll("Ano Emissao");
        assertSame(filterDtoList, actualListAllResult);
        assertTrue(actualListAllResult.isEmpty());
        verify(custeioService).listAll((String) any(), (Pageable) any());
    }

    @Test
    void testGetListFilter2() {

        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.listAll((String) any(), (Pageable) any())).thenReturn(new ArrayList<>());
        ModelAndView actualListFilter = (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class),
                custeioService, mock(CusteioFeignClient.class))).getListFilter("Ano Emissao", null);
        assertTrue(actualListFilter.isReference());
        assertSame(actualListFilter.getModel(), actualListFilter.getModelMap());
        verify(custeioService).listAll((String) any(), (Pageable) any());
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

    @Test
    void testFindFilter3() {

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