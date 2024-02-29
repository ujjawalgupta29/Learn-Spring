package com.learning.jpaandhibernate.course;

import com.learning.jpaandhibernate.course.Course;
import com.learning.jpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.learning.jpaandhibernate.course.jpa.CourseJPARepository;
import com.learning.jpaandhibernate.course.springDataJPA.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJPARepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS JPA", "Ujjawal"));
//        repository.insert(new Course(2, "Learn Spring JPA", "Ujjawal"));
//        repository.insert(new Course(3, "Learn Web Dev JPA", "Ujjawal"));
//
//        repository.deleteById(1);
//
//        System.out.println(repository.selectById(2));
//        System.out.println(repository.selectById(3));

//        System.out.println(repository.selectById(1)); --> will throw error


        repository.save(new Course(1, "Learn AWS JPA", "Ujjawal1"));
        repository.save(new Course(2, "Learn Spring JPA", "Ujjawal2"));
        repository.save(new Course(3, "Learn Web Dev JPA", "Ujjawal2"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        //use custom methods
        System.out.println(repository.findByAuthor("Ujjawal2"));
        System.out.println(repository.findByAuthor("Ujjawal1"));

        System.out.println(repository.findByName("Learn Spring JPA"));
        System.out.println(repository.findByName("JPA"));
    }
}
