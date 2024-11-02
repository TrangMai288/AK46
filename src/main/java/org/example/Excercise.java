package org.example;

public class Excercise {
    public boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEvenNew(int number) {
        return number % 2 == 0;
    }

    /**
     * Viet mot function leap year
     * input year - int
     * return true if leap year
     * return false if leap year
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }

    /**
     * Viet mot ham kiem tra 1 ky tu nhap vao co phai la nguyen am (vowels) hay khong?
     * return true => vowels
     * return false => not vowels
     */
    public static boolean isVowels(String input) {
        if (input.length() != 1) throw new IllegalArgumentException("input string length must be equals 1");
        return "ueoaiUEOAI".contains(input);
    }

    /**
     * ## 2. Password Complexity
     * len > 8 characters
     * include number
     * include lowercase
     * include uppercase
     * include !@#$%^&*()
     *
     * create a function
     *
     * - String as an input
     * - Boolean as an output
     */
    public static boolean isPassword(String input) {
        return input.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{9,}");
    }

    /**
     * tim phan tu lon nhat trong 1 mang
     * [1, 4, 9, 0, 2, 8]
     */

}
