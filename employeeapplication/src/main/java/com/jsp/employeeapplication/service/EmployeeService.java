package com.jsp.employeeapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.dao.EmployeeDao;
import com.jsp.employeeapplication.exception.EmployeeTableEmptyException;
import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.exception.IdWrongException;
import com.jsp.employeeapplication.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	// save
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Employee e = dao.saveEmployee(employee);
		structure.setData(employee);
		structure.setMessage("employee created successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	// update
	public ResponseEntity<ResponseStructure<Employee>> update(Employee emp) {
		Employee db = dao.update(emp);
		if (db != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setData(db);
			structure.setMessage("employee update successfully");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}
		throw new IdNotPresentException();
	}

	// deleteby id

	public ResponseEntity<ResponseStructure<Employee>> deletebyId(int id) {
		Employee db = dao.deleteById(id);
		if (db != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setData(db);
			structure.setMessage("employee deleted successfully ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}
		throw new IdNotPresentException();
	}

	// fetchby id

	public ResponseEntity<ResponseStructure<Employee>> getbyId(int id) {
		Employee db = dao.getempbyId(id);
		if (db != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
			structure.setData(db);
			structure.setMessage("employee fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}
		throw new IdWrongException();

	}

	
	public ResponseEntity<ResponseStructure<List<Employee>>>getEmpsByManagerId(int id ,int pageno ,int recordcount) {
		List<Employee> db = dao.getEmployeesByManagerId(id,pageno, recordcount);
		if (db != null) {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
			structure.setData(db);
			structure.setMessage("employee fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
		throw new IdWrongException();

		
	}
	

	// fetch all

//	public ResponseEntity<ResponseStructure<List<Employee>>> fetchAll() {
//		List<Employee> db = dao.fetchAll();
//		if (db.size() != 0) {
//			ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
//			structure.setData(db);
//			structure.setMessage("All employees are fetched successfully");
//			structure.setStatus(HttpStatus.FOUND.value());
//			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
//		}
//		throw new EmployeeTableEmptyException();
//	}
	
	//getallemployees by pagination
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmpall(int pageno ,int recordcount) {
		List<Employee> db = dao.getallemp(pageno, recordcount);
		if (db.size() != 0) {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
			structure.setData(db);
			structure.setMessage("All employees are fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
		throw new EmployeeTableEmptyException();
		
	}

	//get all employees byname in pagination
	public ResponseEntity<ResponseStructure<List<Employee>>> getbyemployeename(String firstname,int pageno ,int recordcount ) {
		List<Employee> db = dao.getEmpbyname(firstname, pageno, recordcount);
		if (db != null) {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
			structure.setData(db);
			structure.setMessage("employee fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
		throw new IdWrongException();

	}
	
	

	

	
	
}
