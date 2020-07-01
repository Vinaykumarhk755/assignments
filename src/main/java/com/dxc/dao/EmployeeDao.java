package com.dxc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao implements IEmployeeDao {

	public boolean addEmployee(Employee employee) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction transaction = session.beginTransaction();		
		
		Long status = (Long) session.save(employee);
		System.out.println(status);
		
		transaction.commit();
		session.close();
		
		if(status!=null)
			return true;
		return false;
	}

	
	public List<Employee> getAllEmployees() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction transaction = session.beginTransaction();		
		
		Query query = session.createQuery("FROM Employee");
		List<Employee> employees = query.getResultList();
		
		transaction.commit();
		session.close();
		
		return employees;
	}

public Employee searchEmployee(long empId) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction transaction = session.beginTransaction();	
		
		
		//Employee e=(Employee)session.get("Employee",empId);
		
		Employee e2 = session.get(Employee.class,empId);
		System.out.println( e2.getFirstName() + "\t" +e2.getLastName()); 
		transaction.commit();
		session.close();
		 return e2;
}
	
	public boolean updateEmployee(long id1,String fname) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction transaction = session.beginTransaction();	
		
		Query query = session.createQuery("update Employee set firstName=:fname where empId=:Id");
		((org.hibernate.query.Query) query).setDouble("Id",id1 );
		((org.hibernate.query.Query) query).setString("fname",fname);
		int result = query.executeUpdate();
		System.out.println("no of rows updated : " + result);
		System.out.println("updated");
		
		return true;
	}

	public boolean deleteEmployee(long deleteid) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();		
		Transaction transaction = session.beginTransaction();	
		
		Query query1=session.createQuery("delete from Employee where empId=:eiid");
		query1.setParameter("eiid",deleteid);
		int count=query1.executeUpdate();
		System.out.println(count+"records are deleted");
		
		return true;
	}


	

	

}
