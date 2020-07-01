package com.dxc.dao;


import java.io.Serializable;
import java.util.List;

public interface IEmployeeDao<T, Id extends Serializable>{
	
	boolean addEmployee(Employee employee);
	boolean updateEmployee(long empId,String fname);
	boolean deleteEmployee(long empId);
	List<Employee> getAllEmployees();
	Employee searchEmployee(long empId);
}
