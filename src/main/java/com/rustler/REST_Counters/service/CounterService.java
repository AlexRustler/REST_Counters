package com.rustler.REST_Counters.service;

import com.rustler.REST_Counters.model.Counter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
    public Integer getSumCounters() {
        Integer sum = 0;
        for (Counter elem : this.counterStorage.values()
             ) {sum += elem.getCount();

        }
        return sum;
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
