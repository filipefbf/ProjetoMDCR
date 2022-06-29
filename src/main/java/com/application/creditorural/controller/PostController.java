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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
    public Page<CusteioMunicipio> listaCusteio(Pageable pageable) {
        return custeioService.listaCusteio(pageable);
    }

    @GetMapping("/")
    public ModelAndView getList(Model model, Pageable pageable) {
        Page<CusteioMunicipio> custeioList = this.custeioService.findAll(pageable);

        ModelAndView mv = new ModelAndView("custeioMunicipio");
        mv.addObject("custeioList", custeioList);
        return mv;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CusteioMunicipio salvar(@RequestBody CusteioMunicipio custeioMunicipio) {
        return custeioService.salvar(custeioMunicipio);
    }

    @GetMapping("/{id}")
    public CusteioMunicipio buscarClientePorId(@PathVariable("id") Long id) {
        return custeioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao encontrado"));

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

    @GetMapping(value = "/search-ano")
    public ResponseEntity<Page<CusteioMunicipio>> serchByAno(
            @RequestParam(defaultValue = "") String anoEmissao,
            Pageable pageable) {
        Page<CusteioMunicipio> result = custeioMunicipioRepository.searchAno(anoEmissao, pageable);
        return ResponseEntity.ok(result);
    }
}
