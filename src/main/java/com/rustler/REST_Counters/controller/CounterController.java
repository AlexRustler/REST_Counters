package com.rustler.REST_Counters.controller;

import com.rustler.REST_Counters.service.CounterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 05.06.2019.
 */

@Api
@RestController
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/counters/{name}")
    public String create(@RequestBody String name) {
        return this.counterService.create(name);
    }

    @PostMapping("/counters/{name}/{value}")
    public String updateCounter(@RequestBody String name, Integer value) {
        return this.counterService.setValue(name, value);
    }

    @GetMapping("/counters/{name}")
    public Integer getByCounterName(@PathVariable("name") String name) {
        return this.counterService.getValue(name);
    }

    @DeleteMapping("/counters/{name}")
    public String delete(@PathVariable("name") String name) {
        return this.counterService.deleteCounter(name);
    }

    @GetMapping("/counters/sum")
    public String getSumCounters() {
        return this.counterService.getSumCounters();
    }

    @GetMapping("/counters/list")
    public String getListCounters() {
        return "List counters:"+this.counterService.getListCounters();
    }
}
