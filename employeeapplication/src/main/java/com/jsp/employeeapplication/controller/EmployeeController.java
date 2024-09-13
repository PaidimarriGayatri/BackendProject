package com.jsp.employeeapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.service.EmployeeService;
import com.jsp.employeeapplication.util.ResponseStructure;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/saveemp")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid  @RequestBody Employee employee) {
		return employeeservice.saveEmployee(employee);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> update(@RequestBody Employee employee) {
		return employeeservice.update(employee);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> delete(@RequestParam int id) {
		return employeeservice.deletebyId(id);
	}

	@GetMapping("/fetchempid")
	public ResponseEntity<ResponseStructure<Employee>> fetchbyId(@RequestParam int id) {
		return employeeservice.getbyId(id);

	}

//	@GetMapping("/fetchAll")
//	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmp() {
//		return employeeservice.fetchAll();
//	}

	
	//get all employees pagination
	@GetMapping("/getallemp")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllemp(@RequestParam int pageno ,@RequestParam int recordcount){
		return employeeservice.getEmpall(pageno, recordcount);
	}
	
	
     // get employee names
   @GetMapping("/getname/{firstname}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getnamebyemp(@PathVariable String firstname,@RequestParam int pageno ,@RequestParam int recordcount){
		return employeeservice.getbyemployeename(firstname, pageno, recordcount);
         
	}
   
   
   // get all employees by manager
   @GetMapping("/by-manager/{id}")
   public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeesByManager(@PathVariable int id, @RequestParam int pageno ,@RequestParam int recordcount) {
       return employeeservice.getEmpsByManagerId(id,pageno, recordcount);
   }
	
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String,String> validationErrors(MethodArgumentNotValidException exception){
    Map<String,String> errormap= new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(error->{
        errormap.put(error.getField(),error.getDefaultMessage());}
    );
    return errormap;
}
}

