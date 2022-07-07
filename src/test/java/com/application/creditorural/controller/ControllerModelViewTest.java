package com.application.creditorural.controller;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.services.CusteioService;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ControllerModelView.class})
@ExtendWith(SpringExtension.class)
class ControllerModelViewTest {

    @Autowired
    private ControllerModelView controllerModelView;

    @MockBean
    private CusteioService custeioService;

    /**
     * Method under test: {@link ControllerModelView#getAll(Model, Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAll() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R010 Timeout.
        //   Creating the arrange/act section of your test took more than
        //   20,000 seconds. This often happens because Diffblue Cover ran code in your
        //   project which requests user input (System.in), blocks on a lock, or runs into
        //   an infinite or very long loop.
        //   See https://diff.blue/R010 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.services.CusteioService.findAll(org.springframework.data.domain.Pageable)" because "this.custeioService" is null
        //       at com.application.creditorural.controller.ControllerModelView.getAll(ControllerModelView.java:32)
        //   In order to prevent getAll(Model, Pageable)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAll(Model, Pageable).
        //   See https://diff.blue/R013 to resolve this issue.

        ControllerModelView controllerModelView = new ControllerModelView();
        controllerModelView.getAll(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link ControllerModelView#getAll(Model, Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAll2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R010 Timeout.
        //   Creating the arrange/act section of your test took more than
        //   20,000 seconds. This often happens because Diffblue Cover ran code in your
        //   project which requests user input (System.in), blocks on a lock, or runs into
        //   an infinite or very long loop.
        //   See https://diff.blue/R010 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.application.creditorural.repositories.CusteioMunicipioRepository.findAll(org.springframework.data.domain.Pageable)" because "this.repository" is null
        //       at com.application.creditorural.services.CusteioService.findAll(CusteioService.java:42)
        //       at com.application.creditorural.controller.ControllerModelView.getAll(ControllerModelView.java:32)
        //   In order to prevent getAll(Model, Pageable)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAll(Model, Pageable).
        //   See https://diff.blue/R013 to resolve this issue.

        ControllerModelView controllerModelView = new ControllerModelView(new CusteioService());
        controllerModelView.getAll(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link ControllerModelView#getAll(Model, Pageable)}
     */
    @Test
    void testGetAll3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R010 Timeout.
        //   Creating the arrange/act section of your test took more than
        //   20,000 seconds. This often happens because Diffblue Cover ran code in your
        //   project which requests user input (System.in), blocks on a lock, or runs into
        //   an infinite or very long loop.
        //   See https://diff.blue/R010 to resolve this issue.

        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        ControllerModelView controllerModelView = new ControllerModelView(custeioService);
        ConcurrentModel concurrentModel = new ConcurrentModel();
        assertEquals("custeio", controllerModelView.getAll(concurrentModel, null));
        verify(custeioService).findAll((Pageable) any());
        assertTrue(((PageImpl<Object>) concurrentModel.get("custeio")).toList().isEmpty());
    }

    /**
     * Method under test: {@link ControllerModelView#findById(Long)}
     */
    @Test
    void testFindById() throws Exception {
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
        when(custeioService.findById(anyLong())).thenReturn(ofResult);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/custeio/id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(controllerModelView)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"nomeProduto\":\"alice.liddell@example.org\",\"cdPrograma\":\"Cd Programa\",\"cdSubPrograma\":\"Cd Sub"
                                        + " Programa\",\"cdFonteRecurso\":\"Cd Fonte Recurso\",\"cdTipoSeguro\":\"Cd Tipo Seguro\",\"cdEstado\":\"Cd"
                                        + " Estado\",\"cdProduto\":\"alice.liddell@example.org\",\"codCadMu\":\"Cod Cad Mu\",\"cdModalidade\":\"Cd"
                                        + " Modalidade\",\"codIbge\":\"Cod Ibge\",\"Municipio\":\"Municipio\",\"MesEmissao\":\"Mes Emissao\",\"AnoEmissao\":\"Ano"
                                        + " Emissao\",\"VlCusteio\":10.0,\"Atividade\":\"Atividade\",\"AreaCusteio\":1}"));
    }

    /**
     * Method under test: {@link ControllerModelView#update(CusteioMunicipio)}
     */
    @Test
    void testUpdate() throws Exception {
        doNothing().when(custeioService).update((CusteioMunicipio) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/custeio/update");
        MockMvcBuilders.standaloneSetup(controllerModelView)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("custeioMunicipio"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/custeio/getAll"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/custeio/getAll"));
    }

    /**
     * Method under test: {@link ControllerModelView#addNew(CusteioMunicipio)}
     */
    @Test
    void testAddNew() throws Exception {
        doNothing().when(custeioService).AddNew((CusteioMunicipio) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/custeio/addNew");
        MockMvcBuilders.standaloneSetup(controllerModelView)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("custeioMunicipio"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/custeio/getAll"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/custeio/getAll"));
    }

    /**
     * Method under test: {@link ControllerModelView#delete(Long)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(custeioService).deleteById((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/custeio/delete");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(controllerModelView)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/custeio/getAll"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/custeio/getAll"));
    }

}