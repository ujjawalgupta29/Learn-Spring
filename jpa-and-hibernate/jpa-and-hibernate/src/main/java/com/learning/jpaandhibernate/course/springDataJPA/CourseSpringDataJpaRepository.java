package com.learning.jpaandhibernate.course.springDataJPA;

import com.learning.jpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    //defining custom methods, these need to follow conventions like started with "findBy"
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
