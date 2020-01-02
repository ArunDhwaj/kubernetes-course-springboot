package com.sbp.kubernetes.sbp01helloworld;

import com.sbp.kubernetes.sbp01helloworld.environment.InstanceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @Autowired
    private InstanceInformationService service;

    @GetMapping(path = "/")
    public String upAndRunning()
    {
        return "{healthy:true}";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld()
    {
        return "Hello World " + " V3 " + service.retrieveInstanceInfo();
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    //With path varaible
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
