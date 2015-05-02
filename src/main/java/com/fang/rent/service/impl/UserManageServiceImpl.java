package com.fang.rent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fang.rent.dao.UserDao;
import com.fang.rent.entity.Employee;
import com.fang.rent.service.UserManageService;
@Transactional
@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    private UserDao userDao;
	@Override
	public void updateEmp(Employee e) throws Exception {
		userDao.updateEmp(e);
	}

}
