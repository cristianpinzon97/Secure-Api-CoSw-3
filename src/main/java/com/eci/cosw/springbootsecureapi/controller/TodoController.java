package com.eci.cosw.springbootsecureapi.controller;


import com.eci.cosw.springbootsecureapi.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.eci.cosw.springbootsecureapi.service.TodoService;
import java.util.List;

@RestController
@RequestMapping( "api" )
public class TodoController {


    @Autowired
    public TodoService todoService ;

    @RequestMapping( value = "/todo", method = RequestMethod.GET )
    public List<Todo> getTodos() {
      return todoService.getTodoList();
    }

    @RequestMapping( value = "/todo", method = RequestMethod.POST )
    public Todo addTodo(@RequestBody Todo todo ) {
        return todoService.addTodo(todo);
    }

}
