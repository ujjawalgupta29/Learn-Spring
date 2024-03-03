package com.learning.todoWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
  private static final List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Ujjawal", "Book Tickets", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(2, "Ujjawal", "Learn Spring", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(3, "Ujjawal", "Learn DevOps", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
