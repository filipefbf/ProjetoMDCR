package com.application.creditorural.services;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
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
    private CusteioMunicipioRepository repository;

    public Page<CusteioMunicipio> listCusteio(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CusteioMunicipio save(CusteioMunicipio custeioMunicipio) {
        return repository.save(custeioMunicipio);
    }

    public void AddNew(CusteioMunicipio custeioMunicipio) {
        repository.save(custeioMunicipio);
    }

    public Optional<CusteioMunicipio> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Page<CusteioMunicipio> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<CusteioMunicipio> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1,10);
        return repository.findAll(pageable);
    }

    //Filtro Completo por Municipio agrupado por produto com soma dos itens
    public List<FilterConverter> findFilter(String anoEmissao) {
        return repository.searchYearFilter(anoEmissao);
    }

    public void update(CusteioMunicipio custeioMunicipio) {
        repository.save(custeioMunicipio);
    }
}
