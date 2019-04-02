package com.pack.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.Login;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub
		String page = null;
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("from Login l where l.username=:username and l.password=:password");
		q.setParameter("username", login.getUsername());
		q.setParameter("password", login.getPassword());
		
		Login l1 = (Login) q.uniqueResult();
	
		if (l1 != null)
			page = "Home";
		else
			page = "denied";
		t.commit();
		return page;
	}

	public void addBatch(BatchAllocation batchAllocation) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(batchAllocation);
	}

	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Login login=new Login();
		login.setUsername(admin.getId());
		login.setPassword(admin.getPassword());
		this.sessionFactory.getCurrentSession().save(login);
		
		
	}

}
