package com.zee.zee5app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	 public List<Employee> findByDept(String deptName);
	 public List<Employee> findBySalary(int salary);
	 public List<Employee> findBySalaryGreaterThanEqual(int salary);
	 public List<Employee> findByDeptAndSalaryLessThan(String deptName, int salary);
}
