package com.example.learningspring.examples.a7;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class PostgresDBDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {11,12,13,14,15};
    }
}
