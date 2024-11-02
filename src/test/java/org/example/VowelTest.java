package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelTest {
    @Test
    void a_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("a"));
    }

    @Test
    void u_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("u"));
    }

    @Test
    void e_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("e"));
    }

    @Test
    void o_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("o"));
    }

    @Test
    void i_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("i"));
    }

    @Test
    void A_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("A"));
    }

    @Test
    void U_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("U"));
    }

    @Test
    void E_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("E"));
    }

    @Test
    void O_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("O"));
    }

    @Test
    void I_is_vowel() {
        Assert.assertTrue(Excercise.isVowels("I"));
    }

    @Test
    void verify_exception() {
        try {
            Excercise.isVowels("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "input string length must be equals");
        }
    }


}
