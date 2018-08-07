package com.cg.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;
import com.cg.employeeexception.EmployeeException;
import com.cg.employeeservice.IEmpService;


@RestController
@Transactional
public class EmployeeController {
	@Autowired
	private IEmpService service;
	
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public Employee createAccount(Employee employee) {
		try {
			service.createAccount(employee);
		} catch (EmployeeException e) {
			System.err.println(e.getMessage());
		}
		return employee;
		
	}
	
	@RequestMapping(value="/updateEmployee", method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		
		try {
			emp=service.updateAccount(emp);
			return emp;
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return emp;
		
	}
	
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.DELETE)
	public boolean deleteEmployee(Employee emp) {
		boolean b=false;
		try {
			b=service.deleteAccount(emp.geteId());
			return b;
		} catch (EmployeeException e) {
			System.err.println(e.getMessage());
		}
		
		return b;
	}
	
	
	@RequestMapping(value="/findEmployeeById", method=RequestMethod.GET)
	public Employee findEmployee(Employee emp) {
		Employee emp1=null;
		try {
			emp1=service.findEmployeeById(emp.geteId());
			return emp1;
		} catch (EmployeeException e) {
			System.err.println(e.getMessage());
		}
		
		return emp1;
	}
	
	
	@RequestMapping(value="/findAllEmployee", method=RequestMethod.GET)
	public List<Employee> findAllEmployee() {
		List<Employee> emp = null;
		try {
			emp=service.viewAllEmployees();
			return emp;
		} catch (EmployeeException e) {
			System.err.println(e.getMessage());
		}
		
		return emp;
	}
	
	
	
	
	
	
	

}
