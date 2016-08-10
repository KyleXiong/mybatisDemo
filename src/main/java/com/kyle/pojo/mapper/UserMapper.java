package com.kyle.pojo.mapper;

import com.kyle.pojo.User;

public interface UserMapper {

	public User getUser(int id);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
