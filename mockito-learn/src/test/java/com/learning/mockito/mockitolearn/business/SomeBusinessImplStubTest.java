package com.learning.mockito.mockitolearn.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBusinessImplStubTest {

    @Test
    void test() {
        DataService dataService = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
        int result = businessImpl.findGreatestFromAllData();
        Assertions.assertEquals(25, result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}

//Disadv -> we need to implement class again and again for different cases, also its not
// mantainable as if we add new methods to interface ewe need to update all the stubs as well