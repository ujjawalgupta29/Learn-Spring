package com.learning.jpaandhibernate.course.jdbc;

import com.learning.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
    """
    INSERT INTO course(id, name, author)
    values (?, ?, ?)
""";

    private static String DELETE_QUERY =
            """
            DELETE FROM course
            where id = ?
        """;

    private static String SELECT_QUERY =
            """
            SELECT * FROM course
            where id = ?
        """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectById(long id) {
        //ResultSet -> Bean Mapping => known as Row Mapper => ex - BeanPropertyRowMapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
    }
}
