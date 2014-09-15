package com.jiang.gent.dao;

import com.jiang.gent.bean.User;

public interface UserDao {
	public int insertUser(User user);
	public void getUser(int id);
	public int countEmail(String email);
}
