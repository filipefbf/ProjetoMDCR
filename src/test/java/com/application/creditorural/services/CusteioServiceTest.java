package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CusteioServiceTest {

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

    /**
     * Method under test: {@link CusteioService#listCusteio(Pageable)}
     */
    @Test
    void testListCusteio() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualListCusteioResult = custeioService.listCusteio(null);
        assertSame(pageImpl, actualListCusteioResult);
        assertTrue(actualListCusteioResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    /**
     * Method under test: {@link CusteioService#save(CusteioMunicipio)}
     */
    @Test
    void testSave() {
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
        when(custeioMunicipioRepository.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

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
        assertSame(custeioMunicipio, custeioService.save(custeioMunicipio1));
        verify(custeioMunicipioRepository).save((CusteioMunicipio) any());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCusteio();

        PageImpl<CusteioMunicipio> custeioPage = new PageImpl<>(List.of());
    }

    /**
     * Method under test: {@link CusteioService#findById(long)}
     */
    @Test
    void testFindById() {
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

    /**
     * Method under test: {@link CusteioService#deleteById(Long)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(custeioMunicipioRepository).deleteById((Long) any());
        custeioService.deleteById(123L);
        verify(custeioMunicipioRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CusteioService#findAll(Pageable)}
     */
    @Test
    void testFindAll() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualFindAllResult = custeioService.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    /**
     * Method under test: {@link CusteioService#findPage(int)}
     */
    @Test
    void testFindPage() {
        PageImpl<CusteioMunicipio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<CusteioMunicipio> actualFindPageResult = custeioService.findPage(10);
        assertSame(pageImpl, actualFindPageResult);
        assertTrue(actualFindPageResult.toList().isEmpty());
        verify(custeioMunicipioRepository).findAll((Pageable) any());
    }

    /**
     * Method under test: {@link CusteioService#findPage(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindPage2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero
        //       at org.springframework.data.domain.AbstractPageRequest.<init>(AbstractPageRequest.java:45)
        //       at org.springframework.data.domain.PageRequest.<init>(PageRequest.java:45)
        //       at org.springframework.data.domain.PageRequest.of(PageRequest.java:72)
        //       at org.springframework.data.domain.PageRequest.of(PageRequest.java:60)
        //       at com.application.creditorural.services.CusteioService.findPage(CusteioService.java:42)
        //   In order to prevent findPage(int)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findPage(int).
        //   See https://diff.blue/R013 to resolve this issue.

        when(custeioMunicipioRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        custeioService.findPage(0);
    }

    /**
     * Method under test: {@link CusteioService#findFilter(String)}
     */
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