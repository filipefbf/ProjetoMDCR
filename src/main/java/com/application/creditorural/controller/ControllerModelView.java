package com.application.creditorural.controller;

import com.application.creditorural.entities.CusteioMunicipio;
import com.application.creditorural.services.CusteioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Controller
@RequestMapping("/custeio")
public class ControllerModelView {

    @Autowired
    private CusteioService custeioService;

    @RequestMapping("/getAll")
    public String getAll(Model model, Pageable pageable) {
        Page<CusteioMunicipio> custeio = custeioService.findAll(pageable);
        model.addAttribute("custeio", custeio);

        String username = "Filipe";
        model.addAttribute("username", username);

        return "custeio";
    }

    @RequestMapping("/id")
    @ResponseBody
    public Optional<CusteioMunicipio> findById(Long id) {
        return custeioService.findById(id);
    }

    @PostMapping("/addNew")
    public String addNew(CusteioMunicipio custeioMunicipio) {
        custeioService.AddNew(custeioMunicipio);
        return "redirect:/custeio/getAll";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(CusteioMunicipio custeioMunicipio) {
        custeioService.update(custeioMunicipio);
        return "redirect:/custeio/getAll";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        custeioService.deleteById(id);
        return "redirect:/custeio/getAll";
    }


}



