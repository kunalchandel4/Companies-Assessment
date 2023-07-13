package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Student;
import com.test.repo.StudentRepo;

@Service

public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo custRepo;

	@Override
	public Student addStudent(Student cust) {
		// TODO Auto-generated method stub
		Student savedStudent = custRepo.save(cust);

		return savedStudent;
	}

	@Override
	public Student removeStudent(Student cust) {
		// TODO Auto-generated method stub

		Optional<Student> cus = custRepo.findById(cust.getRollNumber());
		if (!cus.isPresent())
			return null;

		custRepo.delete(cust);
		return cus.get();
	}

	@Override
	public Student updateStudent(Student cust) {
		// TODO Auto-generated method stub
		Optional<Student> optional = custRepo.findById(cust.getRollNumber());

		if (optional.isPresent()) {
			Student studen = custRepo.save(cust);
			return studen;	
		}
		return null;
	}

	@Override
	public List<Student> ViewAllStudent() {
		// TODO Auto-generated method stub
		List<Student> viewAllStu = custRepo.findAll();
		if (viewAllStu.size() == 0) {
			return null;
		} else {
			return viewAllStu;
		}

	}

}
