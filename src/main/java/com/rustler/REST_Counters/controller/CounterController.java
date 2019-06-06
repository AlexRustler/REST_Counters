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
@RequestMapping("counters")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/{name}")
    public String create(@RequestBody String name) {
        return this.counterService.create(name);
    }

    @PostMapping("/{name}/{value}")
    public String updateCounter(@RequestBody String name, Integer value) {
        return this.counterService.setValue(name, value);
    }

    @GetMapping("/{name}")
    public Integer getByCounterName(@PathVariable("name") String name) {
        return this.counterService.getValue(name);
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name) {
        return this.counterService.deleteCounter(name);
    }

    @GetMapping("/sum")
    public Integer getSumCounters() {
        return this.counterService.getSumCounters();
    }

    @GetMapping("/")
    public String getListCounters() {
        return this.counterService.getListCounters();
    }
}

