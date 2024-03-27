package com.learning.mockito.mockitolearn.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void test1() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 5, 15});
        int result = businessImpl.findGreatestFromAllData();
        Assertions.assertEquals(25, result);
    }

    @Test
    void test2() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25});
        int result = businessImpl.findGreatestFromAllData();
        Assertions.assertEquals(25, result);
    }
}