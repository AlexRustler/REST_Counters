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
    public ResponseEntity<Counter> create(@RequestBody Counter counter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.counterService.create(counter));
    }

    @PutMapping("/")
    public ResponseEntity<Counter> updateCounter(@RequestBody Counter counter) throws NotFoundException {
        Counter changedCounter = this.counterService.setValue(counter);
        if (changedCounter == null) {
            throw new NotFoundException("Counter "+counter.getName()+" not found!");
        }
        return ResponseEntity.accepted().body(changedCounter);
    }
//
    @GetMapping("/{name}")
    public ResponseEntity<Counter> getByCounterName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(this.counterService.getByName(name));
    }

    @DeleteMapping("/{name}")
    public void delete(@PathVariable("name") String name) {
        this.counterService.deleteCounter(name);
    }

    @GetMapping("/sum")
    public ResponseEntity<Counter> getSumCounters() {
        return ResponseEntity.status(HttpStatus.OK).body(this.counterService.getSumCounters());
    }

    @GetMapping("/")
    public ResponseEntity<Set<String>> getListCountersNames() {
        return ResponseEntity.status(HttpStatus.OK).body(this.counterService.getListCountersNames());
    }
}

