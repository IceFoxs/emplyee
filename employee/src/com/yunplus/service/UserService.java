package com.yunplus.service;

import com.yunplus.domain.User;

public interface UserService {
	User findUser(String username);
	int addUser(User user);
}
