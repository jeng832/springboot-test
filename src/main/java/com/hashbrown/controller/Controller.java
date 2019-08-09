package com.hashbrown.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hashbrown.dao.entity.GroupInfo;
import com.hashbrown.dao.entity.UserInfo;
import com.hashbrown.model.GetGroupResponseBody;
import com.hashbrown.model.GetUserResponseBody;
import com.hashbrown.model.PostGroupRequestBody;
import com.hashbrown.model.PostTest;
import com.hashbrown.model.PostTestResponseBody;
import com.hashbrown.model.PostUserRequestBody;
import com.hashbrown.service.DataService;


@RestController
@EnableAutoConfiguration
public class Controller {
	
	private Logger logger = LoggerFactory.getLogger(Controller.class);

	@Value("${who.am.i}")
	private String whoAmI;
	
	@Autowired
	private DataService dService;
 
    @RequestMapping(value="/who")
    @ResponseBody
    public String who() {
        return whoAmI;
    }
	
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello Spring Boot!";
        
    }
    
    @RequestMapping(value="/group", method=RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<?> postGroup(@RequestBody @Valid PostGroupRequestBody g) {
    	logger.info(g.toString());
    	dService.saveGroup(g);
    	
    	return ResponseEntity.ok().build();
    } 
    
    @RequestMapping(value="/group/{gid}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GetGroupResponseBody> getGroup(@PathVariable Long gid) {
    	GroupInfo group = dService.findByGid(gid);
    	return new ResponseEntity<GetGroupResponseBody>(new GetGroupResponseBody(group), HttpStatus.OK);
    } 

    @RequestMapping(value="/user", method=RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<?> postUser(@RequestBody @Valid PostUserRequestBody u) {
    	dService.saveUser(u);
    	
    	return ResponseEntity.ok().build();
    } 
    
    @RequestMapping(value="/user/{uid}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GetUserResponseBody> getUser(@PathVariable Long uid) {
    	UserInfo user = null;
    	try {
    		user = dService.findByUid(uid);
    	} catch (NoSuchElementException e) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return new ResponseEntity<GetUserResponseBody>(new GetUserResponseBody(user), HttpStatus.OK);
    } 
    
    
    @RequestMapping(value="/group/by/{username}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getGroupName(@PathVariable String username) {
    	String groupName;
    	try {
    		groupName = dService.getGroupNameByUserName(username);
    	} catch (NoSuchElementException e) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return new ResponseEntity<String>(groupName, HttpStatus.OK);
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
    

}
