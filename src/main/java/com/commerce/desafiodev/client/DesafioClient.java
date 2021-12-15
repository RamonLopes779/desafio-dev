package com.commerce.desafiodev.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DesafioClient", url = "http://challenge.dienekes.com.br", path = "/api/numbers")
public interface DesafioClient {
    @GetMapping("/")
    String getNumbers(@RequestParam(name = "page") Integer page);

}