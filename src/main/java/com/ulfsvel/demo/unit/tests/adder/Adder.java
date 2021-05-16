package com.ulfsvel.demo.unit.tests.adder;

import java.util.List;

public class Adder {

    public Integer sum(List<Integer> integers) {
        // @TODO: TASK 1 - Refactor
        Integer accumulator = 0;
        for(Integer i : integers){
            accumulator += i;
        }
        return accumulator;
    }

}
