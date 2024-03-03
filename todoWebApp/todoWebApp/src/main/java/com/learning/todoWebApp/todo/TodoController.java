package com.learning.todoWebApp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private  TodoService todoService;
    @RequestMapping("listTodos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Ujjawal");
        model.put("todos", todos);
        return "listTodos";
    }
}
