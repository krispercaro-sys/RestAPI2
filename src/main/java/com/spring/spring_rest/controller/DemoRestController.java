package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling test endpoints.
 */
@RestController
@RequestMapping("/test")
public class DemoRestController {

    /**
     * Returns a greeting message.
     *
     * @return the "Hello World" string
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}