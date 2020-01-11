package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.SysResult;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		return "userList";
		
	}
	
	@RequestMapping("/ajax")
	public String ajax(Model model) {
		
//		List<User> userList = userService.ajax();
//		model.addAttribute("userList", userList);
		return "ajax";
	}

	@RequestMapping("/findAjaxUser")
	@ResponseBody
	public SysResult findAjaxList() {
		
		try {
			List<User> userList = userService.findAll();
			return new SysResult(200,"服务器处理正确",userList);
		} catch (Exception e) {
			e.printStackTrace();
			return new SysResult(201,"服务器维护中",null);
		}
	}
	
}
