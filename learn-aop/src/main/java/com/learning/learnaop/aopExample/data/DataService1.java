package com.learning.learnaop.aopExample.data;

import org.springframework.stereotype.Service;

@Service
public class DataService1 {
    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int[] {11,22,33,44};
    }
}
