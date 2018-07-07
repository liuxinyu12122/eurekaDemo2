package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value = "add" ,method = RequestMethod.GET)
    public int add(@RequestParam int a, @RequestParam int b)
    {
        List<String> serviceInstance = discoveryClient.getServices();

        logger.info("serviceInstance is :{}",serviceInstance);
        return a+b;
    }
}
