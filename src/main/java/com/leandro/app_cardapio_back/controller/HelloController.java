package com.leandro.app_cardapio_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    // @RequestMapping(method = {RequestMethod.GET}, produces = )
    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
