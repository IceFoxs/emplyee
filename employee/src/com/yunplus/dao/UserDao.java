package com.yunplus.dao;

import com.yunplus.domain.User;

public interface UserDao {
   User findUser(String username);
   int addUser(String username,String password);
}
