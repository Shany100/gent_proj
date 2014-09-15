package com.jiang.gent.dao;

import java.util.List;

import com.jiang.gent.bean.User;

public interface UserDao {
	public int insertUser(User user);
	public User getUser(int id);
	public int countEmail(String email);
	public List<User> checkUser(User user);
}
