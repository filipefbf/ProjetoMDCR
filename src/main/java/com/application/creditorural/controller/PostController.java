package com.application.creditorural.controller;


import com.application.creditorural.Client.PostClient;
import com.application.creditorural.DTO.DTORoot;
import com.application.creditorural.DTO.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    private PostClient postClient;

    @GetMapping
    public DTORoot getAllPosts() {
        return postClient.getAllPosts();
    }
}
