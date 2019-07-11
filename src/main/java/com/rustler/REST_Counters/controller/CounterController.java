package com.rustler.REST_Counters.controller;

import com.rustler.REST_Counters.controller.exceptions.NotFoundException;
import com.rustler.REST_Counters.model.Counter;
import com.rustler.REST_Counters.service.CounterService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Counter create(@RequestBody Counter counter) {
        return this.counterService.create(counter);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Counter updateCounter(@RequestBody Counter counter) throws NotFoundException {
        Counter changedCounter = this.counterService.setValue(counter);
        if (changedCounter == null) {
            throw new NotFoundException("Counter "+counter.getName()+" not found!");
        }
        return changedCounter;
    }
//
    @GetMapping("/{name}")
    public Counter getByCounterName(@PathVariable("name") String name) throws NotFoundException {
        Counter counter = this.counterService.getByName(name);
        if (counter == null) {
            throw new NotFoundException("Counter "+name+" not found!");
        }
        return counter;
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable("name") String name) {
        this.counterService.deleteCounter(name);
    }

    @GetMapping("/sum")
    public Counter getSumCounters() {
        return this.counterService.getSumCounters();
    }

    @GetMapping("/")
    public Set<String> getListCountersNames() {
        return this.counterService.getListCountersNames();
    }
}

