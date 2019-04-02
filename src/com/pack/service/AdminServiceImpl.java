package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.Login;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Transactional
	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub

		System.out.println("inside service");
		String l = null;
		l = adminDao.loginAdmin(login);
		return l;
	}

	@Transactional
	public void addBatch(BatchAllocation batchAllocation) {
		// TODO Auto-generated method stub
		adminDao.addBatch(batchAllocation);
	}

	@Transactional
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.addAdmin(admin);
		
	}

	
}
