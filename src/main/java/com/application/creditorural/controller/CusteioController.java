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
import javax.websocket.server.PathParam;
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

    //Recebendo dados da API
    @PostConstruct
    public DtoRoot getAllPosts() {
        DtoRoot root = custeioFeignClient.getAllData();

        for (ListDto p : root.getValue()) {
            CusteioMunicipio custeioMunicipio = DataConverter.getEntity(p);
            custeioService.save(custeioMunicipio);

        }
        return root;
    }

    //Retorna uma lista de produtos paginada
    @GetMapping
    @ApiOperation(value = "Retorna uma lista paginada - Inserir parametros")
    @ResponseStatus(HttpStatus.OK)
    public Page<CusteioMunicipio> listCusteio(Pageable pageable) {
        return custeioService.listCusteio(pageable);
    }

    //End Point dedicado para a view HTML - mesma acao do endpoint acima para pagina HTML
    @GetMapping("/pages/")
    @ApiOperation(value = "Retorna uma lista paginada - HTML ")
    public ModelAndView getList(Model model, Pageable pageable) {
        Page<CusteioMunicipio> custeioList = this.custeioService.findAll(pageable);

        //ModelAndView mv = new ModelAndView("custeioMunicipio");
        ModelAndView mv = new ModelAndView("dashBoard");
        mv.addObject("custeioList", custeioList);
        return mv;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adicionar um novo registro a lista")
    public CusteioMunicipio save(@RequestBody CusteioMunicipio custeioMunicipio) {
        return custeioService.save(custeioMunicipio);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retornar registro por Id")
    @ResponseStatus(HttpStatus.OK)
    public CusteioMunicipio findByIdd(@PathVariable("id") Long id) {
        return custeioService.findByIdd(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar registro por Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        custeioService.findById(id)
                .map(custeioMunicipio -> {
                    custeioService.deleteById(custeioMunicipio.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found, id " + id));

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza registro da lista")
    public void updateList(@PathVariable("id") Long id, @RequestBody CusteioMunicipio custeioMunicipio) {
        custeioMunicipio.setId(id);
        custeioService.updateList(custeioMunicipio);
    }

    @GetMapping(value = "/search-year")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca todos os registros listados por ano")
    public ResponseEntity<Page<CusteioMunicipio>> serchByAno(@RequestParam(defaultValue = "") String anoEmissao, Pageable pageable) {
        Page<CusteioMunicipio> list = custeioService.serchByAno(anoEmissao, pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/search-year-filter")
    @ApiOperation(value = "Busca todos os registros listados por ano")
    public List<FilterDto> listAll(@PathVariable String anoEmissao) {
        return custeioService.listAll(anoEmissao, Pageable.unpaged());
    }

   @GetMapping(value = "/search-filter")
    @ApiOperation(value = "EndPoint HTML")
    public ModelAndView getListFilter(@PathVariable String anoEmissao, Pageable pageable) {
        List<FilterDto> list = custeioService.listAll(anoEmissao, Pageable.unpaged());

        ModelAndView mv = new ModelAndView("dashBoardFilter");
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = "/search-year-filter/{anoEmissao}")
    @ApiOperation(value = "Busca todos os registros listados por ano agrupados por produtos com valores somados")
    public List<FilterConverter> findFilter(@PathVariable String anoEmissao) {
        return custeioService.findFilter(anoEmissao);
    }
}
