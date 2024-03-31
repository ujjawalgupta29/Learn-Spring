package com.learning.learnaop.aopExample.data;

import com.learning.learnaop.aopExample.annotations.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class DataService2 {
    @TrackTime
    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int[] {111,222,333,444};
    }
}
