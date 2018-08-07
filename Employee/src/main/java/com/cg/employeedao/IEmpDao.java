package com.cg.employeedao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Employee;
import com.cg.employeeexception.EmployeeException;

@Repository
public interface IEmpDao extends JpaRepository<Employee, String> {
	
	@Query("SELECT a FROM Employee a where a.eId = :id") 
	Employee getAccount(@Param("id") String id);
	@Query("SELECT a FROM Employee a")
	List<Employee> viewAllEmployees();

}
