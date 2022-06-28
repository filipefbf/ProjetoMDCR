package com.application.creditorural.Client;

import com.application.creditorural.DTO.DTORoot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/CusteioMunicipioProduto?%24format=json&%24top=1000")
public interface PostClient {

    @GetMapping(value = "")
    DTORoot getAllPosts();
}
