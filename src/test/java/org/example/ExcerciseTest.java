package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcerciseTest {
    @Test
    void verify_10_is_EvenNumber() {
        Assert.assertTrue(Excercise.isEvenNew(10));
    }

    @Test
    void verify_11_is_EvenNumber() {
        Assert.assertFalse(Excercise.isEvenNew(11));
    }

    @Test
    void verify_0_is_EvenNumber() {
        Assert.assertTrue(Excercise.isEvenNew(0));
    }

    @Test
    void verify_2024_is_leap_year() {
        Assert.assertTrue(Excercise.isLeapYear(2024));
    }

    @Test
    void verify_2023_is_leap_year() {
        Assert.assertFalse(Excercise.isLeapYear(2023));
    }
}
