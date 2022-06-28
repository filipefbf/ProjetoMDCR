package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusteioService {

    @Autowired
    private CusteioMunicipioRepository custeioMunicipioRepository;

    public List<CusteioMunicipio> listaCusteio() {
        return custeioMunicipioRepository.findAll();
    }

    public CusteioMunicipio saveAll(CusteioMunicipio custeioMunicipio) {
        return custeioMunicipioRepository.save(custeioMunicipio);
    }

    public CusteioMunicipio salvar(CusteioMunicipio custeioMunicipio) {
        return custeioMunicipioRepository.save(custeioMunicipio);
    }

    public Optional<CusteioMunicipio> buscarPorId(Long id) {
        return custeioMunicipioRepository.findById(id);
    }

    public void removerPorId(Long id) {
        custeioMunicipioRepository.deleteById(id);
    }
}
