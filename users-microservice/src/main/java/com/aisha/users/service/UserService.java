package com.aisha.users.service;

import com.aisha.users.entities.Role;
import com.aisha.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
