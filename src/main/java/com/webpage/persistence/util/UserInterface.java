package com.webpage.persistence.util;

import java.util.List;

import com.webpage.model.User;

public interface UserInterface {
	
	public void addUserDetails(User obj_UserParam);
	public void removeUserDetails(User obj_UserParam);
	public void updateUserDetails(User obj_UserParam);
	public List<User> getAllUsers();

}
