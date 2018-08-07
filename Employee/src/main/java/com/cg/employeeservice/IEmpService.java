package com.cg.employeeservice;

import java.util.List;

import com.cg.bean.Employee;
import com.cg.employeeexception.EmployeeException;

public interface IEmpService {
	
	public Employee createAccount(Employee emp) throws EmployeeException;
	public  Employee updateAccount(Employee emp) throws EmployeeException;
	public  boolean deleteAccount(String id) throws EmployeeException;
	public Employee findEmployeeById(String id) throws EmployeeException;
	public List<Employee> viewAllEmployees() throws EmployeeException;

}
