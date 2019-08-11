package com.hashbrown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hashbrown.dao.entity.UserInfo;
import com.hashbrown.service.DataService;

@Controller
public class ViewController {

	@Autowired
	DataService dService;
	
	@RequestMapping("/hello")
	public String index(Model model, @PageableDefault(size=10, sort="uid",direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("data", dService.findAll(pageable));
		return "hello";
	}
	

}
