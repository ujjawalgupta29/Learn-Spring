package com.learning.todoWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
  private static final List<Todo> todos = new ArrayList<>();
  private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Ujjawal", "Book Tickets", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCount, "Ujjawal", "Learn Spring", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Ujjawal", "Learn DevOps", LocalDate.now().plusYears(2), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
