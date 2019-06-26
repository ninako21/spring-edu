package com.example.springsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springsi.model.User;
import com.example.springsi.service.UserService;

@Controller
@ResponseBody
public class UserManagementController {
	
	//controller는 항상 service를 포함하고 있음
	@Autowired
	private UserService userService;
	
	/*
	
	 /users [GET] : 사용자 전체 보기 List<User> searchUsers
	 /users/3 [GET] : 사용자 상세 보기 User searchUserByUserid(userid)
	 /users [POST] : 사용자 등록 User registUser(User)
	 /users/3 [PUT] : 사용자 수정 User modifyUser(User)
	 /users/3 [DELETE] : 사용자 삭제 User removeUser(userid)

	 */
	
	@GetMapping("/users")
	public List<User> searchUsers() {
		return userService.searchAllUsers();		
	}
	
	@GetMapping("/users/{userid}")
	public User searchUserByUserid(@PathVariable Integer userid) {
		return userService.searchUserByUserID(userid);
	}
	
	@PostMapping("/users")
	public User registUser(@RequestBody User user) {
		
		// user 확보 방법 1.html form방식 2.data json
		System.out.println(user);
		return userService.registUser(user);
		
	}
	
	@PutMapping("/users/3")
	public User modifyUser (User user) {
		return userService.modifyUserInfo(user);
	}
	
	
	@DeleteMapping("/users/3")
	public User removeUser (Integer userid) {
		return userService.removeUser(userid);
	}
	
	
	
}
