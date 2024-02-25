package com.learning.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfController {
    @Autowired
    private CurrencyServiceConfig currencyServiceConfig;
    @RequestMapping("/currencyConf")
    public CurrencyServiceConfig retrieveAllCourses() {
        return currencyServiceConfig;
    }
}
