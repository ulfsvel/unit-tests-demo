package com.ulfsvel.demo.unit.tests.adder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class AdderTest {

    private Adder adder;

    @BeforeEach
    public void beforeEach(){
        adder = new Adder();
    }

    @Test
    public void givenAnEmptyList_whenSum_thenReturn0() {
        Assertions.assertEquals(0, adder.sum(Collections.emptyList()));
    }

    @Test
    public void givenAnListWithOneElement_whenSum_thenReturnTheElementInTheList() {
        Assertions.assertEquals(5, adder.sum(Collections.singletonList(5)));
    }

    @Test
    public void givenAnListWithManyElements_whenSum_thenReturnSumOfElements() {
        Assertions.assertEquals(16, adder.sum(Arrays.asList(3, 5, 8)));
    }


}
