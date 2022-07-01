package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterDtoConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<CusteioMunicipio> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1,10);
        return custeioMunicipioRepository.findAll(pageable);
    }

    public List<FilterDtoConverter> findFilter(String anoEmissao) {
        return custeioMunicipioRepository.searchAnoFilter(anoEmissao);
    }

//    public FilterDto findByYear(String anoEmissao) {
//        CusteioMunicipio entity = (CusteioMunicipio) custeioMunicipioRepository.searchAnoFilter(anoEmissao);
//        FilterDto dto = new FilterDto(entity);
//        return dto;
//    }
}
