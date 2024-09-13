package com.jsp.employeeapplication.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.Entity.Manager;

public interface Managerrepo extends JpaRepository<Manager, Integer> {

	@Query("select a from Manager a where a.id=?1")
	Optional<Manager> findById(int id);

	@Query("select a from Manager a where a.availabilty='AVAILABLE'")
	List<Manager> fetchAllBloodGroup();

	 @Query("SELECT a FROM Manager a WHERE a.Name = :Name")
	  List<Manager> getBymanagername(@Param("Name") String Name, Pageable pageable);
	 
//	 @Query("SELECT a FROM Employee a WHERE a.manager.id = :id")
//	 List<Employee> findByManagerId(@Param("id") int id, Pageable pageable);
}
