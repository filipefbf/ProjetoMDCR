package com.application.creditorural.controller;


import com.application.creditorural.Client.PostClient;
import com.application.creditorural.DTO.DTORoot;
import com.application.creditorural.DTO.PostDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.DataConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.CusteioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private CusteioMunicipioRepository custeioMunicipioRepository;

    @Autowired
    public CusteioService custeioService;

    private PostClient postClient;

    @PostConstruct
    public DTORoot getAllPosts() {
        DTORoot root = postClient.getAllPosts();

        for (PostDto p : root.getValue()) {
            CusteioMunicipio custeioMunicipio = DataConverter.getEntity(p);
            custeioService.saveAll(custeioMunicipio);
        }
        return root;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CusteioMunicipio> listaCusteio() {
        return custeioService.listaCusteio();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CusteioMunicipio salvar(@RequestBody CusteioMunicipio custeioMunicipio) {
        return custeioService.salvar(custeioMunicipio);
    }

    @GetMapping("/{id}")
    public CusteioMunicipio buscarClientePorId(@PathVariable("id") Long id) {
        return custeioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id") Long id) {
        custeioService.buscarPorId(id)
                .map(custeioMunicipio -> {
                    custeioService.removerPorId(custeioMunicipio.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

    }
}
