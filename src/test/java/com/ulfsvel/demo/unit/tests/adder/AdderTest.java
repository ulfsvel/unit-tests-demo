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
    public void givenAnEmptyList_whenSumWithCounter_thenReturn0() {
        Assertions.assertEquals(0, adder.sum(Collections.emptyList()));
    }

    @Test
    public void givenAnListWithOneElement_whenSumWithCounter_thenReturn1() {
        Assertions.assertEquals(5, adder.sum(Collections.singletonList(5)));
    }

    @Test
    public void givenAnListWithManyElements_whenSumWithCounter_thenReturnNumberOfElements() {
        Assertions.assertEquals(16, adder.sum(Arrays.asList(3, 5, 8)));
    }


}
