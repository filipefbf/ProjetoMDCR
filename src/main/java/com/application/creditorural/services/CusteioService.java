package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusteioService {

    @Autowired
    private CusteioMunicipioRepository custeioMunicipioRepository;

    public List<CusteioMunicipio> listaCusteio() {
        return custeioMunicipioRepository.findAll();
    }

    public CusteioMunicipio save(CusteioMunicipio custeioMunicipio) {
        return custeioMunicipioRepository.save(custeioMunicipio);
    }
}
