package com.example.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springsi.model.User;
 
// Datasource 외부데이터

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

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
		// mapper xml에 정의한 query 문 이름으로 sql을 넘겨줘야 함 
		String statement = "com.example.springsi.dao.UserDao.selectUserByKey"; 
		return sqlSession.selectOne(statement, userid);
		
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
