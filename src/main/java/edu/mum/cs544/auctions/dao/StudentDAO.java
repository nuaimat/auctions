package edu.mum.cs544.auctions.dao;

import edu.mum.cs544.auctions.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mo Nuaimat <nuaimat@gmail.com>
 * nuaimat on 6/12/17.
 */
public interface StudentDAO extends JpaRepository<Student, Long> {
}
