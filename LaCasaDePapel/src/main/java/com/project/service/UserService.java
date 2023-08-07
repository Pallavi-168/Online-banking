package com.project.service;

import java.util.List;
import com.project.entity.User;

public interface UserService {
	
	public User getUserById(Integer id);
	public User registerUser(User user);
	public void deleteUserById(Integer id);
    public User UpdateUserById(Integer id, User user);
    public List<User> getAllUsers();
    public User loginUser(User user);
    
}
