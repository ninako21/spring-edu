package com.example.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springsi.model.User;
 
// Datasource 외부데이터

@Repository
public class UserDao {

	public List<User> selectAllUsers() {
		
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "kim", 30));
		userList.add(new User(2, "Lee", 35));
		userList.add(new User(3, "Choi", 40));
		userList.add(new User(4, "Park", 20));
		userList.add(new User(5, "Kang", 25));
		
		return userList;
	}
	
	public User selectUserByKey(Integer userid) {
		
		// DB연동코드 포함 
		// DB연동은 MyBatis 사용
		if (userid == 4) {
			return new User(4, "류현진", 30);
		}
		else if (userid == 3) {
			return new User(3, "강소라", 25);
		}
		else 
			return new User(1, "김연아", 20);
	}
	   
	public User insertUser(User user) {
		System.out.println("[Dao] insert ok..");
		return user;
	}
	
	public User updateUser(User user) {
		return user;
	}
	
	public User deleteUser(Integer userid) {
		return null;
	}
}
