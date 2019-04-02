package com.pack.service;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.Login;

public interface AdminService {

	public String loginAdmin(Login login);
	public void addBatch(BatchAllocation batchAllocation);
	public void addAdmin(Admin admin);
}
