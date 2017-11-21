package com.jcarroyo.data.stub;

import com.jcarroyo.data.TodoService;

import java.util.List;
import java.util.Arrays;

public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }

    public void deleteTodo(String todo){

    }
}
