package com.jcarroyo.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {
    @Test
    public void letsMockListSize(){
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    @Test
    public void letsMockListSizeWithMultipleReturnValues(){
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    public void letsMockListGet(){
        List<String> list = mock(List.class);
        Mockito.when(list.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void letsMockListGetWithAny(){
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(("in28Minutes"));
        assertEquals("in28Minutes", list.get(0));
        assertEquals("in28Minutes", list.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockingListGetThowException(){
        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        list.get(0);
    }

    @Test
    public void bddAliases_UsingGivenWillReturn(){
        List<String> list = mock(List.class);
        //given
        given(list.get(Mockito.anyInt())).willReturn("in28Minutes");
        assertThat("in28Minutes", is(list.get(0)));
        assertThat("in28Minutes", is(list.get(1)));
    }

}
