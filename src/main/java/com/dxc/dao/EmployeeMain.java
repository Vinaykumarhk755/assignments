package com.dxc.dao;

import java.util.Scanner;


import java.util.List;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee emp1 = new Employee(67878626,"Prashant", "p",23455.00);
		Employee emp2 = new Employee(1378681,"shanti", "s",23456.00);
		
		//Add employee 
		EmployeeDao employeeDao = new EmployeeDao();
		System.out.println(employeeDao.addEmployee(emp1));
		System.out.println(employeeDao.addEmployee(emp2));
		
		//Get all the employees
		List<Employee> employees = employeeDao.getAllEmployees();
		for(Employee employee : employees) {
			System.out.println(employee.getEmpId() + "\t" +employee.getFirstName());
		}
		System.out.println("searched element");
		System.out.println("enter the employee id to search related details");
		Long id=sc.nextLong();
		System.out.println(employeeDao.searchEmployee(id));
		System.out.println("updation start");
		System.out.println("enter the employee id to update related details");
		Long id1=sc.nextLong();
		System.out.println("enter the employee fname to which have put");
		String fname=sc.next();
		
		System.out.println(employeeDao.updateEmployee(id1,fname));
		System.out.println("deletion part start");
		System.out.println("enter the emp id to delete all  the details of that id");
		Long deleteid=sc.nextLong();
		System.out.println(employeeDao.deleteEmployee(deleteid));
		
		
		
		
				
	}

}

