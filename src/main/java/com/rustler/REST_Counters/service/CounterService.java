package com.rustler.REST_Counters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
        this.counterStorage.put(name, value);
        return "Counter "+name+" set value to "+value.toString();
    }

    public Integer getValue(String name) {
        return this.counterStorage.get(name);
    }

    public String deleteCounter(String name) {
        this.counterStorage.remove(name);
        return "Counter "+name+" deleted.";
    }

    public String getSumCounters() {
        Integer sum = 0;
        for (Integer elem : this.counterStorage.values()
             ) {sum += elem;
            
        };
        return "Sum of counters = "+sum.toString();
    }

    public String getListCounters() {
        return this.counterStorage.keySet().toString();
    }
}
