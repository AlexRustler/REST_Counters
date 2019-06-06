package com.rustler.REST_Counters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 05.06.2019.
 */

@Service
public class CounterService {
    private Map<String, Integer> counterStorage;

    @Autowired
    public CounterService() {
        this.counterStorage = new HashMap<>();
    }

    public String create(String name) {
        this.counterStorage.put(name, 0);
        return "Counter "+name+" created.";
    }

    public String setValue(String name, Integer value) {
        if (this.counterStorage.containsKey(name)) {
            this.counterStorage.put(name, value);
            return "Counter " + name + " set value to " + value.toString();
        }
        else return "Counter " + name + " not found!";
    }

    public Integer getValue(String name) {
        return this.counterStorage.get(name);
    }

    public String deleteCounter(String name) {
        if (this.counterStorage.containsKey(name)) {
            this.counterStorage.remove(name);
            return "Counter " + name + " deleted.";
        }
        else return "Counter " + name + " not found!";
    }

    public Integer getSumCounters() {
        Integer sum = 0;
        for (Integer elem : this.counterStorage.values()
             ) {sum += elem;
            
        }
        return sum;
    }

    public String getListCounters() {
        return this.counterStorage.keySet().toString();
    }
}
