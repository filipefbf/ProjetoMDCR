package com.application.creditorural.services;

import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusteioService {

    @Autowired
    private CusteioMunicipioRepository custeioMunicipioRepository;

    public Page<CusteioMunicipio> listaCusteio(Pageable pageable) {
        return custeioMunicipioRepository.findAll(pageable);
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

    public Page<CusteioMunicipio> findAll(Pageable pageable) {
        return custeioMunicipioRepository.findAll(pageable);
    }

//    public FilterDto findByYear(String anoEmissao) {
//        CusteioMunicipio entity = (CusteioMunicipio) custeioMunicipioRepository.searchAnoFilter(anoEmissao);
//        FilterDto dto = new FilterDto(entity);
//        return dto;
//    }
}
