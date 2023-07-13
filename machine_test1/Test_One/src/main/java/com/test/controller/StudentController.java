package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	private StudentService cSer;

	@PostMapping
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student customer) {

		Student savedStudent = cSer.addStudent(customer);
		return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Student> deleteStudentHandler(@RequestBody Student customer) {

		Student deletedStudent = cSer.removeStudent(customer);

		return new ResponseEntity<>(deletedStudent, HttpStatus.ACCEPTED);
	}

	@PutMapping
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student customer) {

		Student updatedStudent = cSer.updateStudent(customer);
	

		return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<List<Student>> viewAllStudentHandler() {

		List<Student> studentlist = cSer.ViewAllStudent();

		return new ResponseEntity<>(studentlist, HttpStatus.OK);

	}


}
