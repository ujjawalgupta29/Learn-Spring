package com.learning.learnaop.aopExample.business;

import com.learning.learnaop.aopExample.annotations.TrackTime;
import com.learning.learnaop.aopExample.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    @Autowired
    private DataService2 dataService2;

    public int calculateMin() {
        int[] data = dataService2.retrieveData();
//        throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).min().orElse(0);
    }
}
