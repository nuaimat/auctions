package edu.mum.cs544.auctions.service;

import edu.mum.cs544.auctions.domain.Student;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/19/17.
 */
public interface IStudentService {
    Student getStudent(long studentid);
}
