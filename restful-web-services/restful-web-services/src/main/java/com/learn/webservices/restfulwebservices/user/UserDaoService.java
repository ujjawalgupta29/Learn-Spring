package com.learn.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Ujjawal", LocalDate.now().minusYears(24)));
        users.add(new User(++usersCount, "Akshay", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Boke", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
