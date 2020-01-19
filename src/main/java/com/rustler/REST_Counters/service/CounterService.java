package com.rustler.REST_Counters.service;

import com.rustler.REST_Counters.model.Counter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * Created by User on 05.06.2019.
 */

@Service
public class CounterService {
    private final Map<String, Counter> counterStorage = new ConcurrentHashMap<>();

    public Counter create(Counter counter) {
        String name = counter.getName();
        this.counterStorage.putIfAbsent(name, counter);
        return this.counterStorage.get(name);
    }

    public Counter setValue(Counter counter) {
        String name = counter.getName();
        if (this.counterStorage.containsKey(name)) {
            this.counterStorage.replace(name, counter);
            return this.counterStorage.get(name);
        }
        return null;
    }

    public void deleteCounter(String name) {
       this.counterStorage.remove(name);

    }
//
    public Counter getSumCounters() {
        Stream<Counter> stream = this.counterStorage.values().stream();
        Integer sum = stream.reduce(0,
                (x, y)-> x + y.getCount(),
                (x, y)->x + y);

        return new Counter("sum", sum);
    }
//
    public Set<String> getListCountersNames() {
        return this.counterStorage.keySet();
    }

    public Counter getByName(String name) {
        if (this.counterStorage.containsKey(name)) {
            return this.counterStorage.get(name);
        }
        return  null;
    }
}
