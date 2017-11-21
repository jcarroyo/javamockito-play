package com.jcarroyo.business;

import static org.junit.Assert.assertEquals;
import com.jcarroyo.data.TodoService;
import com.jcarroyo.data.stub.TodoServiceStub;
import org.junit.Test;
import java.util.List;

public class TodoBusinessImplementationStubTest {
    @Test
    public void usingAStub(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImplementation todoBusinessImplementation = new TodoBusinessImplementation(todoService);
        List<String> todos = todoBusinessImplementation.retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }
}
