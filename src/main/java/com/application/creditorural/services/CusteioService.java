package com.application.creditorural.services;

import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.FilterConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CusteioService {

    @Autowired
    private ModelMapper modelMapper;

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

    public CusteioMunicipio findByIdd(Long id) {
        Optional<CusteioMunicipio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(id);
        }
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

    public FilterDto toFilterDto(CusteioMunicipio custeioMunicipio) {
        return modelMapper.map(custeioMunicipio, FilterDto.class);
    }

    public List<FilterDto> listAll(String anoEmissao, Pageable pageable) {
        return repository.searchAno(anoEmissao, pageable)
                .stream()
                .map(this::toFilterDto)
                .collect(Collectors.toList());
    }

    public Page<CusteioMunicipio> serchByAno(String anoEmissao, Pageable pageable) {
        Page<CusteioMunicipio> result = repository.searchAno(anoEmissao, pageable);
        return result;
    }

    public void updateList(CusteioMunicipio custeioMunicipio) {
        repository.findById(custeioMunicipio.getId())
                .map(CusteioMunicipio -> {
                    modelMapper.map(custeioMunicipio, CusteioMunicipio);
                    repository.save(custeioMunicipio);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado nao encontrado."));
    }


}
