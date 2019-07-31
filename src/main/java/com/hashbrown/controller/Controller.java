package com.hashbrown.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Controller {
	@Value("${who.am.i}")
	private String whoAmI;
 
    @RequestMapping(value="/")
    @ResponseBody
    public String sampleHome() {
        
        return "Hello Spring Boot!";
        
    }
    
    @RequestMapping(value="/health")
    @ResponseBody
    public String health() {
        return "Health";
    }
    
    @RequestMapping(value="/who")
    @ResponseBody
    public String who() {
        return whoAmI;
    }
}
