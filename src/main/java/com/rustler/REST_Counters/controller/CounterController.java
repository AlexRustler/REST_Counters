package com.rustler.REST_Counters.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 05.06.2019.
 */

@Api
@RestController
public class CounterController {

    @Autowired
    public CounterController() {
    }

    @PostMapping("/counters/{name}")
    public String create(@RequestBody String name) {
        return name+" created";
    }

    @PostMapping("/counters/{name}/{value}")
    public String updateCounter(@RequestBody String name, int value) {
        return name+" changed";
    }

    @GetMapping("/counters/{name}")
    public String getByCounterName(@PathVariable("name") String name) {
        return "Get value of "+name+" counter";
    }

    @DeleteMapping("/counters/{name}")
    public String delete(@PathVariable("name") String name) {
        return name + " deleteted";
    }

    @GetMapping("/counters/sum")
    public String getSumCounters() {
        return "Calculated...";
    }

    @GetMapping("/counters/list")
    public String getListCounters() {
        return "List counters:";
    }
}
