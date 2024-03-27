package com.learning.mockito.mockitolearn.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int maxValue = Integer.MIN_VALUE;

        for(int value : data) {
            if(value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}