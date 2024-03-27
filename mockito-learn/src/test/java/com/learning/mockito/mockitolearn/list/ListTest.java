package com.learning.mockito.mockitolearn.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        Assertions.assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(2);
        Assertions.assertEquals(3, listMock.size());
        Assertions.assertEquals(2, listMock.size());
        Assertions.assertEquals(2, listMock.size());
        Assertions.assertEquals(2, listMock.size());
    }

    @Test
    void genericParameter() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Test");
        Assertions.assertEquals("Test", listMock.get(0));
        Assertions.assertEquals("Test", listMock.get(1));
        Assertions.assertEquals("Test", listMock.get(2));
    }
}
