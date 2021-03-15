package com.app.repo.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	private boolean flag=Boolean.FALSE;
	
	
	public Boolean saveOrUpdate(Employee employee) {
     Session session=sessionFactory.openSession();
     session.saveOrUpdate(employee);
     session.beginTransaction().commit();
     flag=Boolean.TRUE;
		return flag;
	}

	public Boolean deleteEmployee(Integer id) {
		Session session=sessionFactory.openSession();
		session.delete(getId(id));
		session.beginTransaction().commit();
		flag=Boolean.TRUE;
		return flag;
	}

	public Employee getId(Integer id) {
		return (Employee) sessionFactory.openSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return sessionFactory.openSession().createCriteria(Employee.class).list();
	}

}
