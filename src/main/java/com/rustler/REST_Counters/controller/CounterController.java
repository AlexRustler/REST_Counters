package com.rustler.REST_Counters.controller;

import com.rustler.REST_Counters.model.Counter;
import com.rustler.REST_Counters.service.CounterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public Counter create(@RequestBody Counter counter) {
        return this.counterService.create(counter);
    }

    @PutMapping("/")
    public Counter updateCounter(@RequestBody Counter counter) {
        return this.counterService.setValue(counter);
    }
//
    @GetMapping("/{name}")
    public Integer getByCounterName(@PathVariable("name") String name) {
        return this.counterService.getValue(name);
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable("name") String name) {
        this.counterService.deleteCounter(name);
    }

    @GetMapping("/sum")
    public Integer getSumCounters() {
        return this.counterService.getSumCounters();
    }

    @GetMapping("/")
    public Set<String> getListCountersNames() {
        return this.counterService.getListCountersNames();
    }
}

