package com.hashbrown.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hashbrown.model.GroupRequestBody;
import com.hashbrown.model.PostTest;
import com.hashbrown.model.PostTestResponseBody;
import com.hashbrown.repository.Repository;
import com.hashbrown.repository.vo.GroupInfo;
import com.hashbrown.service.DataService;


@RestController
@EnableAutoConfiguration
public class Controller {
	
	private Logger logger = LoggerFactory.getLogger(Controller.class);

	@Value("${who.am.i}")
	private String whoAmI;
	
	@Autowired
	private DataService dService;
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String sampleHome() {
    	GroupInfo g = new GroupInfo("aaa");
    	logger.info(g.toString());
    	dService.save(g);
        return "Hello Spring Boot!";
        
    }
    
    @RequestMapping(value="/group", method=RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void postGroup(@RequestBody GroupRequestBody g) {
    	logger.info(g.toString());
    	dService.save(new GroupInfo(g.getGroupName()));
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
