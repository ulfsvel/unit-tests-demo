package com.ulfsvel.demo.unit.tests.adder;

import java.util.List;

public class Adder {

    public Integer sum(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }

}
