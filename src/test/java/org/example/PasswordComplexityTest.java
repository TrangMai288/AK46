package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordComplexityTest {
    // nhap du 8 ky tu, co so, co ky tu thuong, co ky tu hoa, !@#$%^&*()
    @Test
    void verify_Trang123456$_is_password() {
        Assert.assertTrue(Excercise.isPassword("Trang123456$"));
    }

    // nhap khong du 8 ky tu
    @Test
    void verify_Trang1$_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("Trang1$"));
    }

    // nhap 8 ky tu
    @Test
    void verify_Trang12$_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("Trang12$"));
    }

    // nhap khong co so
    @Test
    void verify_Trangabc$_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("Trangabc$"));
    }

    // nhap khong co chu thuong
    @Test
    void verify_TRANG123$_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("TRANG123$"));
    }

    // nhap khong co chu hoa
    @Test
    void verify_trang123$_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("trang123$"));
    }

    // nhap khong co ky tu dac biet
    @Test
    void verify_Trang1234_is_not_password() {
        Assert.assertFalse(Excercise.isPassword("Trang1234"));
    }
}
