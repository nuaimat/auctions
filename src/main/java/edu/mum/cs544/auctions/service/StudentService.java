package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Student;
import edu.mum.cs544.auctions.dao.StudentDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements IStudentService {
	private StudentDAO studentdao;

	public StudentService(StudentDAO studentDAO) {
		this.studentdao = studentDAO;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public Student getStudent(long studentid) {
		//return studentdao.load(studentid);
		return studentdao.findOne(studentid);
	}
}
