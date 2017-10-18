package com.yunplus.dao;

import java.util.List;

import com.yunplus.domain.Employee;

public interface EmplyeeDao {
       List getAllEmployee();
       Employee findOneEmployee(int eid);
       int deleteEmployee(int id);
       int updateEmployee(int id,String name,int salary ,int job);
       int insertEmployee(int id,String name,int salary ,int job);  
}
