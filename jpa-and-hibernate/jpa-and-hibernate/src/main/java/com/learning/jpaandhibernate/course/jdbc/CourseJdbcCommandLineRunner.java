package com.learning.jpaandhibernate.course.jdbc;

import com.learning.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "Ujjawal"));
        repository.insert(new Course(2, "Learn Spring", "Ujjawal"));
        repository.insert(new Course(3, "Learn Web Dev", "Ujjawal"));

        repository.deleteById(1);

        System.out.println(repository.selectById(2));
        System.out.println(repository.selectById(3));

//        System.out.println(repository.selectById(1)); --> will throw error
    }
}
