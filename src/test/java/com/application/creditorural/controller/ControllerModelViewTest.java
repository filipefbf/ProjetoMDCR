package com.application.creditorural.controller;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.services.CusteioService;
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

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ControllerModelView.class})
@ExtendWith(SpringExtension.class)
class ControllerModelViewTest {

    @Autowired
    private ControllerModelView controllerModelView;

    @MockBean
    private CusteioService custeioService;

    @Test
    void testGetAll3() {

        CusteioService custeioService = mock(CusteioService.class);
        when(custeioService.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        ControllerModelView controllerModelView = new ControllerModelView(custeioService);
        ConcurrentModel concurrentModel = new ConcurrentModel();
        assertEquals("custeio", controllerModelView.getAll(concurrentModel, null));
        verify(custeioService).findAll((Pageable) any());
        assertTrue(((PageImpl<Object>) concurrentModel.get("custeio")).toList().isEmpty());
    }

    @Test
    void testFindById() throws Exception {
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
                                "{\"id\":123,\"nomeProduto\":\"SOJA\",\"cdPrograma\":\"Cd Programa\",\"cdSubPrograma\":\"Cd Sub"
                                        + " Programa\",\"cdFonteRecurso\":\"Cd Fonte Recurso\",\"cdTipoSeguro\":\"Cd Tipo Seguro\",\"cdEstado\":\"Cd"
                                        + " Estado\",\"cdProduto\":\"SOJA\",\"codCadMu\":\"Cod Cad Mu\",\"cdModalidade\":\"Cd"
                                        + " Modalidade\",\"codIbge\":\"Cod Ibge\",\"Municipio\":\"Municipio\",\"MesEmissao\":\"Mes Emissao\",\"AnoEmissao\":\"Ano"
                                        + " Emissao\",\"VlCusteio\":10.0,\"Atividade\":\"Atividade\",\"AreaCusteio\":1}"));
    }
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