package com.application.creditorural.controller;


import com.application.creditorural.Client.CusteioFeignClient;
import com.application.creditorural.DTO.DtoRoot;
import com.application.creditorural.DTO.FilterDto;
import com.application.creditorural.DTO.ListDto;
import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.entities.converter.DataConverter;
import com.application.creditorural.entities.converter.FilterConverter;
import com.application.creditorural.repositories.CusteioMunicipioRepository;
import com.application.creditorural.services.CusteioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/list")
@Api(value = "API REST Custeio Produtos por Municipio")
@CrossOrigin(origins = "*")
public class CusteioController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CusteioMunicipioRepository repository;

    @Autowired
    public CusteioService custeioService;

    private CusteioFeignClient custeioFeignClient;

    @PostConstruct
    public DtoRoot getAllPosts() {
        DtoRoot root = custeioFeignClient.getAllData();

        for (ListDto p : root.getValue()) {
            CusteioMunicipio custeioMunicipio = DataConverter.getEntity(p);
            custeioService.save(custeioMunicipio);

        }
        return root;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de produtos")
    @ResponseStatus(HttpStatus.OK)
    public Page<CusteioMunicipio> listCusteio(Pageable pageable) {
        return custeioService.listCusteio(pageable);
    }

    @GetMapping("/pages/")
    @ApiOperation(value = "Retorna uma lista de por pagina")
    public ModelAndView getList(Model model, Pageable pageable) {
        Page<CusteioMunicipio> custeioList = this.custeioService.findAll(pageable);

        //ModelAndView mv = new ModelAndView("custeioMunicipio");
        ModelAndView mv = new ModelAndView("dashBoard");
        mv.addObject("custeioList", custeioList);
        return mv;
    }

//    @GetMapping("/")
//    public String getAllPages(Model model){
//        return getOnePage(model, 1);
//    }
//    @GetMapping("/{pageNumber}")
//    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
//        Page<CusteioMunicipio> page = this.custeioService.findPage(currentPage);
//        int totalPages = page.getTotalPages();
//        long totalItems = page.getTotalElements();
//        List<CusteioMunicipio> custeioList = page.getContent();
//
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("custeioList", custeioList);
//        return "/";
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CusteioMunicipio save(@RequestBody CusteioMunicipio custeioMunicipio) {
        return custeioService.save(custeioMunicipio);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna produto único por Id")
    @ResponseStatus(HttpStatus.OK)
    public CusteioMunicipio findById(@PathVariable("id") Long id) {
        return custeioService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao encontrado"));

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta produto único por Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        custeioService.findById(id)
                .map(custeioMunicipio -> {
                    custeioService.deleteById(custeioMunicipio.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

    }

    @GetMapping(value = "/search-year")
    public ResponseEntity<Page<CusteioMunicipio>> serchByAno(
            @RequestParam(defaultValue = "") String anoEmissao,
            Pageable pageable) {
        Page<CusteioMunicipio> result = repository.searchAno(anoEmissao, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search-year-filter")
    public List<FilterDto> listAll() {
        return repository.findAll()
                .stream()
                .map(this::toFilterDto)
                .collect(Collectors.toList());
    }

    public FilterDto toFilterDto(CusteioMunicipio custeioMunicipio) {
        return modelMapper.map(custeioMunicipio, FilterDto.class);
    }

    @GetMapping(value = "/search-filter")
    public ModelAndView getListFilter(Model model, Pageable pageable) {

        List<FilterDto> list = this.repository.findAll()
                    .stream()
                    .map(this::toFilterDto)
                    .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView("dashBoardFilter");
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = "/search-year-filter/{anoEmissao}")
    @ApiOperation(value = "Retorna produtos agrupados por municipio")
    public List<FilterConverter> findFilter(@PathVariable String anoEmissao) {
        return custeioService.findFilter(anoEmissao);
    }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void updateList(@PathVariable("id") Long id, @RequestBody CusteioMunicipio custeioMunicipio) {
        custeioService.findById(id)
                .map(CusteioMunicipio -> {
                    modelMapper.map(custeioMunicipio, CusteioMunicipio);
                    custeioService.save(custeioMunicipio);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dado nao encontrado."));
    }

}
