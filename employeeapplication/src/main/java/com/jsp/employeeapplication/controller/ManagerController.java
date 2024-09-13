package com.jsp.employeeapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.jsp.employeeapplication.Entity.Manager;
import com.jsp.employeeapplication.service.Managerservice;
import com.jsp.employeeapplication.util.ResponseStructure;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private Managerservice service;

	@PostMapping("/savemanager")
	public ResponseEntity<ResponseStructure<Manager>> saveEmployee(@Valid @RequestBody Manager manager) {
		return service.savemanager(manager);

	}

	@PutMapping("/updatemanager")
	public ResponseEntity<ResponseStructure<Manager>> updatemanager(@RequestBody Manager manager) {
		return service.updateManag(manager);

	}

	@DeleteMapping("/deletemanager")
	public ResponseEntity<ResponseStructure<Manager>> delete(@RequestParam int id) {
		return service.deletebyId(id);
	}

	@GetMapping("/fetchid")
	public ResponseEntity<ResponseStructure<Manager>> fetchbyId(@RequestParam int id) {
		return service.fetchbyId(id);

	}

	@GetMapping("/fetchAllBloodgroup")
	public ResponseEntity<ResponseStructure<List<Manager>>> getAllbloodgroup() {
		return service.fetchAllBllodgroup();
	}
	
	
	
	//get all employees pagination
		@GetMapping("/getallmanager")
		public ResponseEntity<ResponseStructure<List<Manager>>> getAllmanagers(@RequestParam int pageno ,@RequestParam int recordcount){
			return service.getManagerall(pageno, recordcount);
		}
		
		
	     // get employee names
	   @GetMapping("/getmanagername/{Name}")
		public ResponseEntity<ResponseStructure<List<Manager>>> getmanagersname(@PathVariable String Name,@RequestParam int pageno ,@RequestParam int recordcount){
			return service.getbyemployeename(Name, pageno, recordcount);
	         
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
