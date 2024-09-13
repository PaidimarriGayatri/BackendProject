package com.jsp.employeeapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.repo.Employeerepo;

@Repository
public class EmployeeDao {

	@Autowired
	private Employeerepo employeerepo;

	// save
	public Employee saveEmployee(Employee employee) {
		return employeerepo.save(employee);

	}

	// update
	public Employee update(Employee employeeupdate) {

		Employee db = this.getempbyId(employeeupdate.getId());
		if (db != null) {
			if (employeeupdate.getEmail() != null) {
				db.setEmail(employeeupdate.getEmail());
			}
			if (employeeupdate.getFirstname() != null) {
				db.setFirstname(employeeupdate.getFirstname());

			}
			if (employeeupdate.getLastname() != null) {
				db.setLastname(employeeupdate.getLastname());

			}
			if (employeeupdate.getPassword() != null) {
				db.setPassword(employeeupdate.getPassword());
			}
			if (employeeupdate.getAvailabilty() != null) {
				db.setAvailabilty(employeeupdate.getAvailabilty());
			}
			if (employeeupdate.getBloodgroup() != null) {
				db.setBloodgroup(employeeupdate.getBloodgroup());
			}
			return employeerepo.save(db);
		} else
			return null;

	}

	// deletebyid
	public Employee deleteById(int id) {

		Optional<Employee> db = employeerepo.findById(id);
		if (db.isEmpty()) {
			throw new IdNotPresentException();

		} else {
			employeerepo.deleteById(id);
			return db.get();
		}

	}

	// fetchbyid
	public Employee getempbyId(int id) {
		Optional<Employee> db = employeerepo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			throw new IdNotPresentException();
		}

	}

	// fetchby all
//	public List<Employee> fetchAll() {
//		return employeerepo.findAll();
//	}

	
	//pagination based on pageno and record count
	public List<Employee> getallemp(int pageno ,int recordcount){
		Pageable pagable=PageRequest.of(pageno, recordcount);
		return employeerepo.findAll(pagable).get().toList();
	}
	
	
	//pagination based on empname get 
	public List<Employee> getEmpbyname(String firstname,int pageno ,int recordcount ){
		Pageable pagable= PageRequest.of(pageno, recordcount);
		return employeerepo.getByempname(firstname,pagable);
	}
	
	//pagination to employees by manager
	  public List<Employee> getEmployeesByManagerId(int id, int pageno ,int recordcount) {
			Pageable pagable= PageRequest.of(pageno, recordcount);
	        return employeerepo.findByManagerId(id, pagable);
	    }
}
