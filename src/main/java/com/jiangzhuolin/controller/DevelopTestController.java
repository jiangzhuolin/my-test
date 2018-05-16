package com.jiangzhuolin.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@RestController
@ComponentScan(basePackages = {"com.lenovo"})
public class DevelopTestController {
	
 	
	@RequestMapping("/")
    public String greeting() {
        return "Hello World -- testing!";
    }
}
