package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class CusteioServiceTest {

    @InjectMocks
    private CusteioService service;
    @Mock
    private CusteioMunicipioRepository repository;
    private CusteioMunicipio custeioMunicipio;
    private Optional<CusteioMunicipio> municipioOpitional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCusteio();
    }
    @Test
    void whenfindByIdThenReturnAnNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(municipioOpitional);

        Optional<CusteioMunicipio> response = service.findById(1L);

        assertNotNull(response);
        //Assertions.assertEquals(municipioOpitional, response.get());
        //Assertions.assertEquals(1L, response.getId());
    }

//    @Test
//    void whenfindAllThenReturnListCusteio() {
//        when(repository.findAll()).thenReturn(List.of(custeioMunicipio));
//        Pageable paginacao = PageRequest.of(0, 10);
//        List<CusteioMunicipio> response = service.findAll(pageable);
//
//        assertNotNull(response);
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
    void findPage() {
    }

    @Test
    void findFilter() {
    }

    private void startCusteio() {
        custeioMunicipio = new CusteioMunicipio(1,"RIO VERDE DE MATO GROSSO","BOVINOS","05","2015","0999","0","0300","-1","13",574.57,"1300","38986","2","26","500",0);
        municipioOpitional = Optional.of(new CusteioMunicipio(1,"RIO VERDE DE MATO GROSSO","BOVINOS","05","2015","0999","0","0300","-1","13",574.57,"1300","38986","2","26","500",0));
    }
}