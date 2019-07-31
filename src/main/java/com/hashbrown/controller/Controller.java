package com.hashbrown.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hashbrown.model.PostTest;
import com.hashbrown.model.PostTestResponseBody;

@RestController
@EnableAutoConfiguration
public class Controller {
	@Value("${who.am.i}")
	private String whoAmI;
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String sampleHome() {
        return "Hello Spring Boot!";
        
    }
    
    @RequestMapping(value="/input/{val}", method=RequestMethod.GET)
    @ResponseBody
    public String getInput(@PathVariable(value="val") String v) {
        return v;
        
    }
    
    @RequestMapping(value="/test", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PostTestResponseBody> postTest(@RequestBody PostTest body) {
        //return new PostTestResponseBody(body);
    	return new ResponseEntity<PostTestResponseBody>(new PostTestResponseBody(body), HttpStatus.BAD_REQUEST);
        
    }
    
    @RequestMapping(value="/test", method=RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<PostTestResponseBody> putTest(@RequestBody PostTest body) {
        //return new PostTestResponseBody(body);
    	return new ResponseEntity<PostTestResponseBody>(new PostTestResponseBody(body), HttpStatus.OK);
        
    }
    
    @RequestMapping(value="/test", method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<PostTestResponseBody> deleteTest(@RequestBody PostTest body) {
        //return new PostTestResponseBody(body);
    	return new ResponseEntity<PostTestResponseBody>(new PostTestResponseBody(body), HttpStatus.INTERNAL_SERVER_ERROR);
        
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
