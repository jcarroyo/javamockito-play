package com.jcarroyo.business;

import com.jcarroyo.data.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoBusinessImplementationMockitoTest {
    @Test
    public void usingMockito(){
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
        TodoBusinessImplementation todoBusinessImplementation = new TodoBusinessImplementation(todoService);
        List<String> todos = todoBusinessImplementation.retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void usingMockito_UsingBDD(){
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImplementation todoBusinessImplementation = new TodoBusinessImplementation(todoService);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        //GIVEN
        given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
        //WHEN
        List<String> todos = todoBusinessImplementation.retrieveTodosRelatedToSpring("Ranga");
        //THEN
        assertThat(todos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow(){
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
        TodoBusinessImplementation todoBusinessImplementation = new TodoBusinessImplementation(todoService);
        todoBusinessImplementation.deleteTodosNotRelatedToSpring("Ranga");
        verify(todoService).deleteTodo("Learn to Dance");
        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
        verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
    }
}
