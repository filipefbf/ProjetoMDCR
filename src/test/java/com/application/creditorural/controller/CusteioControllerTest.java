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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CusteioControllerTest {

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPosts() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.lang.Iterable.iterator()" because "iterable" is null
        //       at com.application.creditorural.controller.CusteioController.getAllPosts(CusteioController.java:53)
        //   In order to prevent getAllPosts()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPosts().
        //   See https://diff.blue/R013 to resolve this issue.

        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(new DtoRoot());
        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), custeioFeignClient)).getAllPosts();
    }

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
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

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPosts3() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.DTO.DtoRoot.getValue()" because "root" is null
        //       at com.application.creditorural.controller.CusteioController.getAllPosts(CusteioController.java:53)
        //   In order to prevent getAllPosts()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPosts().
        //   See https://diff.blue/R013 to resolve this issue.

        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(null);
        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), custeioFeignClient)).getAllPosts();
    }

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    void testGetAllPosts4() {

        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        assertThrows(ResponseStatusException.class,
                () -> (new CusteioController(modelMapper, repository, new CusteioService(), custeioFeignClient)).getAllPosts());
        verify(custeioFeignClient).getAllData();
    }

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPosts5() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.save(Object)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.save(CusteioService.java:26)
        //       at com.application.creditorural.controller.CusteioController.getAllPosts(CusteioController.java:55)
        //   In order to prevent getAllPosts()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPosts().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<ListDto> listDtoList = new ArrayList<>();
        listDtoList.add(new ListDto("Municipio", "alice.liddell@example.org", "Mes Emissao", "Ano Emissao", "Cd Programa",
                "Cd Sub Programa", "Cd Fonte Recurso", "Cd Tipo Seguro", "Cd Estado", 10.0d, "alice.liddell@example.org",
                "Cod Cad Mu", "Atividade", "Cd Modalidade", "Cod Ibge", 1));

        DtoRoot dtoRoot = new DtoRoot();
        dtoRoot.setValue(listDtoList);
        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(dtoRoot);
        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), custeioFeignClient)).getAllPosts();
    }

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    void testGetAllPosts6() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

        ArrayList<ListDto> listDtoList = new ArrayList<>();
        listDtoList.add(new ListDto("Municipio", "alice.liddell@example.org", "Mes Emissao", "Ano Emissao", "Cd Programa",
                "Cd Sub Programa", "Cd Fonte Recurso", "Cd Tipo Seguro", "Cd Estado", 10.0d, "alice.liddell@example.org",
                "Cod Cad Mu", "Atividade", "Cd Modalidade", "Cod Ibge", 1));

        DtoRoot dtoRoot = new DtoRoot();
        dtoRoot.setValue(listDtoList);
        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(dtoRoot);
        assertSame(dtoRoot, (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class),
                custeioService, custeioFeignClient)).getAllPosts());
        verify(custeioService).save((CusteioMunicipio) any());
        verify(custeioFeignClient).getAllData();
    }

    /**
     * Method under test: {@link CusteioController#getAllPosts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPosts7() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.DTO.ListDto.getMunicipio()" because "dto" is null
        //       at com.application.creditorural.entities.converter.DataConverter.getEntity(DataConverter.java:11)
        //       at com.application.creditorural.controller.CusteioController.getAllPosts(CusteioController.java:54)
        //   In order to prevent getAllPosts()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPosts().
        //   See https://diff.blue/R013 to resolve this issue.

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);

        ArrayList<ListDto> listDtoList = new ArrayList<>();
        listDtoList.add(null);

        DtoRoot dtoRoot = new DtoRoot();
        dtoRoot.setValue(listDtoList);
        CusteioFeignClient custeioFeignClient = mock(CusteioFeignClient.class);
        when(custeioFeignClient.getAllData()).thenReturn(dtoRoot);
        (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class), custeioService,
                custeioFeignClient)).getAllPosts();
    }

    /**
     * Method under test: {@link CusteioController#listCusteio(Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testListCusteio() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findAll(org.springframework.data.domain.Pageable)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.listCusteio(CusteioService.java:22)
        //       at com.application.creditorural.controller.CusteioController.listCusteio(CusteioController.java:65)
        //   In order to prevent listCusteio(Pageable)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   listCusteio(Pageable).
        //   See https://diff.blue/R013 to resolve this issue.

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), mock(CusteioFeignClient.class)))
                .listCusteio(null);
    }

    /**
     * Method under test: {@link CusteioController#listCusteio(Pageable)}
     */
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

    /**
     * Method under test: {@link CusteioController#getList(Model, Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetList() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findAll(org.springframework.data.domain.Pageable)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findAll(CusteioService.java:38)
        //       at com.application.creditorural.controller.CusteioController.getList(CusteioController.java:71)
        //   In order to prevent getList(Model, Pageable)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getList(Model, Pageable).
        //   See https://diff.blue/R013 to resolve this issue.

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        CusteioController custeioController = new CusteioController(modelMapper, repository, new CusteioService(),
                mock(CusteioFeignClient.class));
        custeioController.getList(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link CusteioController#getList(Model, Pageable)}
     */
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

    /**
     * Method under test: {@link CusteioController#save(CusteioMunicipio)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.save(Object)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.save(CusteioService.java:26)
        //       at com.application.creditorural.controller.CusteioController.save(CusteioController.java:100)
        //   In order to prevent save(CusteioMunicipio)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(CusteioMunicipio).
        //   See https://diff.blue/R013 to resolve this issue.

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
        custeioController.save(custeioMunicipio);
    }

    /**
     * Method under test: {@link CusteioController#save(CusteioMunicipio)}
     */
    @Test
    void testSave2() {

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
        assertSame(custeioMunicipio, custeioController.save(custeioMunicipio1));
        verify(custeioService).save((CusteioMunicipio) any());
    }

    /**
     * Method under test: {@link CusteioController#findById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findById(Object)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findById(CusteioService.java:30)
        //       at com.application.creditorural.controller.CusteioController.findById(CusteioController.java:107)
        //   In order to prevent findById(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), mock(CusteioFeignClient.class)))
                .findById(123L);
    }

    /**
     * Method under test: {@link CusteioController#findById(Long)}
     */
    @Test
    void testFindById2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findById(anyLong())).thenReturn(Optional.of(custeioMunicipio));
        assertSame(custeioMunicipio, (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class),
                custeioService, mock(CusteioFeignClient.class))).findById(123L));
        verify(custeioService).findById(anyLong());
    }

    /**
     * Method under test: {@link CusteioController#findById(Long)}
     */
    @Test
    void testFindById3() {

        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class))).findById(123L));
        verify(custeioService).findById(anyLong());
    }

    /**
     * Method under test: {@link CusteioController#remove(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemove() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findById(Object)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findById(CusteioService.java:30)
        //       at com.application.creditorural.controller.CusteioController.remove(CusteioController.java:116)
        //   In order to prevent remove(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   remove(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), mock(CusteioFeignClient.class))).remove(123L);
    }

    /**
     * Method under test: {@link CusteioController#remove(Long)}
     */
    @Test
    void testRemove2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).deleteById((Long) any());
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class), custeioService,
                mock(CusteioFeignClient.class))).remove(123L);
        verify(custeioService).findById(anyLong());
        verify(custeioService).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CusteioController#remove(Long)}
     */
    @Test
    void testRemove3() {

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
        CusteioService custeioService = mock(CusteioService.class);
        doThrow(new ResponseStatusException(HttpStatus.CONTINUE)).when(custeioService).deleteById((Long) any());
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        assertThrows(ResponseStatusException.class, () -> (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class))).remove(123L));
        verify(custeioService).findById(anyLong());
        verify(custeioService).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CusteioController#remove(Long)}
     */
    @Test
    void testRemove4() {

        CusteioMunicipio custeioMunicipio = mock(CusteioMunicipio.class);
        when(custeioMunicipio.getId()).thenReturn(123L);
        doNothing().when(custeioMunicipio).setAnoEmissao((String) any());
        doNothing().when(custeioMunicipio).setAreaCusteio(anyInt());
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
        doNothing().when(custeioMunicipio).setVlCusteio(anyDouble());
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
        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).deleteById((Long) any());
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        (new CusteioController(new ModelMapper(), mock(CusteioMunicipioRepository.class), custeioService,
                mock(CusteioFeignClient.class))).remove(123L);
        verify(custeioService).findById(anyLong());
        verify(custeioService).deleteById((Long) any());
        verify(custeioMunicipio).getId();
        verify(custeioMunicipio).setAnoEmissao((String) any());
        verify(custeioMunicipio).setAreaCusteio(anyInt());
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
        verify(custeioMunicipio).setId(anyLong());
        verify(custeioMunicipio).setMesEmissao((String) any());
        verify(custeioMunicipio).setMunicipio((String) any());
        verify(custeioMunicipio).setNomeProduto((String) any());
        verify(custeioMunicipio).setVlCusteio(anyDouble());
    }

    /**
     * Method under test: {@link CusteioController#remove(Long)}
     */
    @Test
    void testRemove5() {

        CusteioMunicipio custeioMunicipio = mock(CusteioMunicipio.class);
        when(custeioMunicipio.getId()).thenReturn(123L);
        doNothing().when(custeioMunicipio).setAnoEmissao((String) any());
        doNothing().when(custeioMunicipio).setAreaCusteio(anyInt());
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
        doNothing().when(custeioMunicipio).setVlCusteio(anyDouble());
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
        CusteioService custeioService = mock(CusteioService.class);
        doNothing().when(custeioService).deleteById((Long) any());
        when(custeioService.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> (new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class))).remove(123L));
        verify(custeioService).findById(anyLong());
        verify(custeioMunicipio).setAnoEmissao((String) any());
        verify(custeioMunicipio).setAreaCusteio(anyInt());
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
        verify(custeioMunicipio).setId(anyLong());
        verify(custeioMunicipio).setMesEmissao((String) any());
        verify(custeioMunicipio).setMunicipio((String) any());
        verify(custeioMunicipio).setNomeProduto((String) any());
        verify(custeioMunicipio).setVlCusteio(anyDouble());
    }

    /**
     * Method under test: {@link CusteioController#serchByAno(String, Pageable)}
     */
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

    /**
     * Method under test: {@link CusteioController#serchByAno(String, Pageable)}
     */
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

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    void testListAll() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(new ArrayList<>());
        ModelMapper modelMapper = new ModelMapper();
        assertTrue((new CusteioController(modelMapper, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class))).listAll().isEmpty());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    void testListAll2() {

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
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        ModelMapper modelMapper = new ModelMapper();
        assertEquals(1, (new CusteioController(modelMapper, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class))).listAll().size());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    void testListAll3() {

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

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio1);
        custeioMunicipioList.add(custeioMunicipio);
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        ModelMapper modelMapper = new ModelMapper();
        assertEquals(2, (new CusteioController(modelMapper, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class))).listAll().size());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    void testListAll4() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        ModelMapper modelMapper = new ModelMapper();
        assertThrows(ResponseStatusException.class, () -> (new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class))).listAll());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testListAll5() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
        //       at com.application.creditorural.controller.CusteioController.toFilterDto(CusteioController.java:141)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.application.creditorural.controller.CusteioController.listAll(CusteioController.java:137)
        //   In order to prevent listAll()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   listAll().
        //   See https://diff.blue/R013 to resolve this issue.

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
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        (new CusteioController(null, custeioMunicipioRepository, new CusteioService(), mock(CusteioFeignClient.class)))
                .listAll();
    }

    /**
     * Method under test: {@link CusteioController#listAll()}
     */
    @Test
    void testListAll6() {

        ModelMapper modelMapper = mock(ModelMapper.class);
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
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        assertEquals(1, (new CusteioController(modelMapper, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class))).listAll().size());
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#toFilterDto(CusteioMunicipio)}
     */
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
        FilterDto actualToFilterDtoResult = custeioController.toFilterDto(custeioMunicipio);
        assertEquals("Ano Emissao", actualToFilterDtoResult.getAnoEmissao());
        assertEquals(10.0d, actualToFilterDtoResult.getVlCusteio());
        assertEquals("alice.liddell@example.org", actualToFilterDtoResult.getNomeProduto());
        assertEquals("Municipio", actualToFilterDtoResult.getMunicipio());
        assertEquals(123L, actualToFilterDtoResult.getId().longValue());
        assertEquals("Cod Cad Mu", actualToFilterDtoResult.getCodCadMu());
        assertEquals("alice.liddell@example.org", actualToFilterDtoResult.getCdProduto());
    }

    /**
     * Method under test: {@link CusteioController#toFilterDto(CusteioMunicipio)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToFilterDto2() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
        //       at com.application.creditorural.controller.CusteioController.toFilterDto(CusteioController.java:141)
        //   In order to prevent toFilterDto(CusteioMunicipio)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toFilterDto(CusteioMunicipio).
        //   See https://diff.blue/R013 to resolve this issue.

        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        CusteioController custeioController = new CusteioController(null, repository, new CusteioService(),
                mock(CusteioFeignClient.class));

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
        custeioController.toFilterDto(custeioMunicipio);
    }

    /**
     * Method under test: {@link CusteioController#toFilterDto(CusteioMunicipio)}
     */
    @Test
    void testToFilterDto3() {

        ModelMapper modelMapper = mock(ModelMapper.class);
        FilterDto filterDto = new FilterDto();
        when(modelMapper.map((Object) any(), (Class<FilterDto>) any())).thenReturn(filterDto);
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
        assertSame(filterDto, custeioController.toFilterDto(custeioMunicipio));
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
    }

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
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

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
    @Test
    void testGetListFilter2() {

        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("custeioMunicipioFiltro");
        custeioMunicipio.setCdEstado("custeioMunicipioFiltro");
        custeioMunicipio.setCdFonteRecurso("custeioMunicipioFiltro");
        custeioMunicipio.setCdModalidade("custeioMunicipioFiltro");
        custeioMunicipio.setCdProduto("alice.liddell@example.org");
        custeioMunicipio.setCdPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdSubPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdTipoSeguro("custeioMunicipioFiltro");
        custeioMunicipio.setCodCadMu("custeioMunicipioFiltro");
        custeioMunicipio.setCodIbge("custeioMunicipioFiltro");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setMunicipio("custeioMunicipioFiltro");
        custeioMunicipio.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio.setVlCusteio(10.0d);

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio);
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        ModelMapper modelMapper = new ModelMapper();
        CusteioController custeioController = new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class));
        ModelAndView actualListFilter = custeioController.getListFilter(new ConcurrentModel(), null);
        assertTrue(actualListFilter.isReference());
        assertSame(actualListFilter.getModel(), actualListFilter.getModelMap());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
    @Test
    void testGetListFilter3() {

        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("custeioMunicipioFiltro");
        custeioMunicipio.setCdEstado("custeioMunicipioFiltro");
        custeioMunicipio.setCdFonteRecurso("custeioMunicipioFiltro");
        custeioMunicipio.setCdModalidade("custeioMunicipioFiltro");
        custeioMunicipio.setCdProduto("alice.liddell@example.org");
        custeioMunicipio.setCdPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdSubPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdTipoSeguro("custeioMunicipioFiltro");
        custeioMunicipio.setCodCadMu("custeioMunicipioFiltro");
        custeioMunicipio.setCodIbge("custeioMunicipioFiltro");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setMunicipio("custeioMunicipioFiltro");
        custeioMunicipio.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio.setVlCusteio(10.0d);

        CusteioMunicipio custeioMunicipio1 = new CusteioMunicipio();
        custeioMunicipio1.setAnoEmissao("custeioMunicipioFiltro");
        custeioMunicipio1.setAreaCusteio(1);
        custeioMunicipio1.setAtividade("custeioMunicipioFiltro");
        custeioMunicipio1.setCdEstado("custeioMunicipioFiltro");
        custeioMunicipio1.setCdFonteRecurso("custeioMunicipioFiltro");
        custeioMunicipio1.setCdModalidade("custeioMunicipioFiltro");
        custeioMunicipio1.setCdProduto("alice.liddell@example.org");
        custeioMunicipio1.setCdPrograma("custeioMunicipioFiltro");
        custeioMunicipio1.setCdSubPrograma("custeioMunicipioFiltro");
        custeioMunicipio1.setCdTipoSeguro("custeioMunicipioFiltro");
        custeioMunicipio1.setCodCadMu("custeioMunicipioFiltro");
        custeioMunicipio1.setCodIbge("custeioMunicipioFiltro");
        custeioMunicipio1.setId(123L);
        custeioMunicipio1.setMesEmissao("custeioMunicipioFiltro");
        custeioMunicipio1.setMunicipio("custeioMunicipioFiltro");
        custeioMunicipio1.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio1.setVlCusteio(10.0d);

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio1);
        custeioMunicipioList.add(custeioMunicipio);
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        ModelMapper modelMapper = new ModelMapper();
        CusteioController custeioController = new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class));
        ModelAndView actualListFilter = custeioController.getListFilter(new ConcurrentModel(), null);
        assertTrue(actualListFilter.isReference());
        assertSame(actualListFilter.getModel(), actualListFilter.getModelMap());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
    @Test
    void testGetListFilter4() {

        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        ModelMapper modelMapper = new ModelMapper();
        CusteioController custeioController = new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class));
        assertThrows(ResponseStatusException.class, () -> custeioController.getListFilter(new ConcurrentModel(), null));
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListFilter5() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.modelmapper.ModelMapper.map(Object, java.lang.Class)" because "this.modelMapper" is null
        //       at com.application.creditorural.controller.CusteioController.toFilterDto(CusteioController.java:141)
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
        //       at com.application.creditorural.controller.CusteioController.getListFilter(CusteioController.java:150)
        //   In order to prevent getListFilter(Model, Pageable)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getListFilter(Model, Pageable).
        //   See https://diff.blue/R013 to resolve this issue.

        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("custeioMunicipioFiltro");
        custeioMunicipio.setCdEstado("custeioMunicipioFiltro");
        custeioMunicipio.setCdFonteRecurso("custeioMunicipioFiltro");
        custeioMunicipio.setCdModalidade("custeioMunicipioFiltro");
        custeioMunicipio.setCdProduto("alice.liddell@example.org");
        custeioMunicipio.setCdPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdSubPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdTipoSeguro("custeioMunicipioFiltro");
        custeioMunicipio.setCodCadMu("custeioMunicipioFiltro");
        custeioMunicipio.setCodIbge("custeioMunicipioFiltro");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setMunicipio("custeioMunicipioFiltro");
        custeioMunicipio.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio.setVlCusteio(10.0d);

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio);
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        CusteioController custeioController = new CusteioController(null, custeioMunicipioRepository, new CusteioService(),
                mock(CusteioFeignClient.class));
        custeioController.getListFilter(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link CusteioController#getListFilter(Model, Pageable)}
     */
    @Test
    void testGetListFilter6() {

        ModelMapper modelMapper = mock(ModelMapper.class);
        when(modelMapper.map((Object) any(), (Class<FilterDto>) any())).thenReturn(new FilterDto());

        CusteioMunicipio custeioMunicipio = new CusteioMunicipio();
        custeioMunicipio.setAnoEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setAreaCusteio(1);
        custeioMunicipio.setAtividade("custeioMunicipioFiltro");
        custeioMunicipio.setCdEstado("custeioMunicipioFiltro");
        custeioMunicipio.setCdFonteRecurso("custeioMunicipioFiltro");
        custeioMunicipio.setCdModalidade("custeioMunicipioFiltro");
        custeioMunicipio.setCdProduto("alice.liddell@example.org");
        custeioMunicipio.setCdPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdSubPrograma("custeioMunicipioFiltro");
        custeioMunicipio.setCdTipoSeguro("custeioMunicipioFiltro");
        custeioMunicipio.setCodCadMu("custeioMunicipioFiltro");
        custeioMunicipio.setCodIbge("custeioMunicipioFiltro");
        custeioMunicipio.setId(123L);
        custeioMunicipio.setMesEmissao("custeioMunicipioFiltro");
        custeioMunicipio.setMunicipio("custeioMunicipioFiltro");
        custeioMunicipio.setNomeProduto("alice.liddell@example.org");
        custeioMunicipio.setVlCusteio(10.0d);

        ArrayList<CusteioMunicipio> custeioMunicipioList = new ArrayList<>();
        custeioMunicipioList.add(custeioMunicipio);
        CusteioMunicipioRepository custeioMunicipioRepository = mock(CusteioMunicipioRepository.class);
        when(custeioMunicipioRepository.findAll()).thenReturn(custeioMunicipioList);
        CusteioController custeioController = new CusteioController(modelMapper, custeioMunicipioRepository,
                new CusteioService(), mock(CusteioFeignClient.class));
        ModelAndView actualListFilter = custeioController.getListFilter(new ConcurrentModel(), null);
        assertTrue(actualListFilter.isReference());
        assertSame(actualListFilter.getModel(), actualListFilter.getModelMap());
        verify(modelMapper).map((Object) any(), (Class<FilterDto>) any());
        verify(custeioMunicipioRepository).findAll();
    }

    /**
     * Method under test: {@link CusteioController#findFilter(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFilter() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.searchYearFilter(String)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findFilter(CusteioService.java:47)
        //       at com.application.creditorural.controller.CusteioController.findFilter(CusteioController.java:160)
        //   In order to prevent findFilter(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findFilter(String).
        //   See https://diff.blue/R013 to resolve this issue.

        ModelMapper modelMapper = new ModelMapper();
        CusteioMunicipioRepository repository = mock(CusteioMunicipioRepository.class);
        (new CusteioController(modelMapper, repository, new CusteioService(), mock(CusteioFeignClient.class)))
                .findFilter("Ano Emissao");
    }

    /**
     * Method under test: {@link CusteioController#findFilter(String)}
     */
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

    /**
     * Method under test: {@link CusteioController#updateList(Long, CusteioMunicipio)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateList() {

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findById(Object)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findById(CusteioService.java:30)
        //       at com.application.creditorural.controller.CusteioController.updateList(CusteioController.java:166)
        //   In order to prevent updateList(Long, CusteioMunicipio)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateList(Long, CusteioMunicipio).
        //   See https://diff.blue/R013 to resolve this issue.

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
    }

    /**
     * Method under test: {@link CusteioController#updateList(Long, CusteioMunicipio)}
     */
    @Test
    void testUpdateList2() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio1);
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));

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
        custeioController.updateList(123L, custeioMunicipio2);
        verify(custeioService).save((CusteioMunicipio) any());
        verify(custeioService).findById(anyLong());
    }

    /**
     * Method under test: {@link CusteioController#updateList(Long, CusteioMunicipio)}
     */
    @Test
    void testUpdateList3() {

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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        CusteioController custeioController = new CusteioController(new ModelMapper(),
                mock(CusteioMunicipioRepository.class), custeioService, mock(CusteioFeignClient.class));

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
        assertThrows(ResponseStatusException.class, () -> custeioController.updateList(123L, custeioMunicipio1));
        verify(custeioService).save((CusteioMunicipio) any());
        verify(custeioService).findById(anyLong());
    }

    /**
     * Method under test: {@link CusteioController#updateList(Long, CusteioMunicipio)}
     */
    @Test
    void testUpdateList4() {

        ModelMapper modelMapper = mock(ModelMapper.class);
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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio1);
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        CusteioController custeioController = new CusteioController(modelMapper, mock(CusteioMunicipioRepository.class),
                custeioService, mock(CusteioFeignClient.class));

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
        custeioController.updateList(123L, custeioMunicipio2);
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(custeioService).save((CusteioMunicipio) any());
        verify(custeioService).findById(anyLong());
    }

    /**
     * Method under test: {@link CusteioController#updateList(Long, CusteioMunicipio)}
     */
    @Test
    void testUpdateList5() {

        ModelMapper modelMapper = mock(ModelMapper.class);
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
        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.save((CusteioMunicipio) any())).thenReturn(custeioMunicipio);
        when(custeioService.findById(anyLong())).thenReturn(Optional.empty());
        CusteioController custeioController = new CusteioController(modelMapper, mock(CusteioMunicipioRepository.class),
                custeioService, mock(CusteioFeignClient.class));

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
        assertThrows(ResponseStatusException.class, () -> custeioController.updateList(123L, custeioMunicipio1));
        verify(custeioService).findById(anyLong());
    }
}