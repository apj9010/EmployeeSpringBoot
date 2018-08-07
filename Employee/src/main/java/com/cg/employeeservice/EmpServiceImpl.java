package com.cg.employeeservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;
import com.cg.employeedao.IEmpDao;
import com.cg.employeeexception.EmployeeException;
@Service
@Transactional
@PersistenceContext
public class EmpServiceImpl implements IEmpService {
	@Autowired
	IEmpDao repo;
	@Autowired
	EntityManager em;

	@Override
	public Employee createAccount(Employee emp) throws EmployeeException {
		if(validateName(emp.geteName()) && validateSalary(emp.getSalary())) {
			repo.save(emp);
			return emp;	
		}
		else {
			throw new EmployeeException("Account Cannot be created");
		}
		
	}

	private boolean validateSalary(double salary) throws EmployeeException {
		if(salary>0) {
			return true;
		}
		else {
		throw new EmployeeException("Salary amount should be greater than 0");
	}
		}

	private boolean validateName(String geteName) throws EmployeeException{
		
		if(geteName.matches("[A-Za-z]{2,}")) {
			return true;
		}
		else
		{
			throw new EmployeeException("Name should start with Capital letter");
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee updateAccount(Employee emp) throws EmployeeException {
		Employee emp1=repo.getAccount(emp.geteId());
		emp1.setSalary(emp.getSalary());
		repo.save(emp1);
		return emp1;
	}

	@Override
	public boolean deleteAccount(String id) throws EmployeeException {
		
		repo.deleteById(id);
		
		return true;
		
	}

	@Override
	public Employee findEmployeeById(String id) throws EmployeeException {
		
		return repo.getAccount(id);
	}

	@Override
	public List<Employee> viewAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		return repo.viewAllEmployees();
	}

}
