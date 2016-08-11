package com.kyle.pojo.mapper;

import java.util.List;

import com.kyle.pojo.User;

public interface UserMapper {

	public User getUser(int id);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> getUsers();
}
