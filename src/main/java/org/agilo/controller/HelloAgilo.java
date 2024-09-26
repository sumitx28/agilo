package org.agilo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloAgilo {
    @GetMapping("/hello-agilo")
    public String helloAgilo() {
        return "Hello";
    }
}
