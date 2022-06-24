package com.application.creditorural.Client;

import com.application.creditorural.DTO.DTORoot;
import com.application.creditorural.DTO.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
@FeignClient(name = "post", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/CusteioMunicipioProduto?%24format=json&%24top=5000")
public interface PostClient {

    //@GetMapping(value = "/posts")
    @GetMapping(value = "")
    DTORoot getAllPosts();
}
