package com.application.creditorural.controller;


import com.application.creditorural.Client.PostClient;
import com.application.creditorural.DTO.DTORoot;
import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.DTO.PostDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.DataConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.CusteioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private ModelMapper modelMapper;

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

    @GetMapping(value = "/search-ano-filter")
    public List<FilterDto> listarTodos() {
        return custeioMunicipioRepository.findAll()
                .stream()
                .map(this::toFilterDto)
                .collect(Collectors.toList());
    }

    private FilterDto toFilterDto(CusteioMunicipio custeioMunicipio) {
        return modelMapper.map(custeioMunicipio, FilterDto.class);
    }

    @GetMapping(value = "/search-filter")
    public ModelAndView getListFilter(Model model, Pageable pageable) {

        List<FilterDto> list = this.custeioMunicipioRepository.findAll()
                    .stream()
                    .map(this::toFilterDto)
                    .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("custeioMunicipioFiltro");
        mv.addObject("list", list);
        return mv;
    }
}
