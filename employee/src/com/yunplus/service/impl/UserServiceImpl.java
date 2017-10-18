package com.yunplus.service.impl;

import com.yunplus.dao.UserDao;
import com.yunplus.dao.impl.UserDaoImpl;
import com.yunplus.domain.User;
import com.yunplus.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userdao = new UserDaoImpl();
	@Override
	public User findUser(String username) {
		User u = null;
		u=userdao.findUser(username);
		return u;
	}

	@Override
	public int addUser(User user) {
		int status = 0;
		status=userdao.addUser(user.getUsername(),user.getPassword());
		return status;
	}

}
