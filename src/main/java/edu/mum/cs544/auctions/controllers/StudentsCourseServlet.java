package edu.mum.cs544.auctions.controllers;
/*
import edu.mum.cs544.auctions.domain.Student;
import edu.mum.cs544.auctions.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");
		
		long studentid = -1;
		Student student = null;

		ServletContext context = getServletContext();
		WebApplicationContext applicationContext =
				WebApplicationContextUtils.getWebApplicationContext(context);
		StudentService studentService =
				applicationContext.getBean("studentService", StudentService.class);




		//StudentService studentService = new StudentService();
		
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			student = studentService.getStudent(studentid);
		}
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		

	}

}

*/
