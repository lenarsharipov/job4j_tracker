package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null));
        assertEquals(exception.getMessage(), "Password cannot be null");
    }

    @Test
    void whenInvalidLength() {
        String password = "a1b2C3";
        String rsl = PasswordValidator.validate(password);
        String expected = "Длина пароля не находится в диапазоне [8, 32]";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasNoDigit() {
        String password = "abacbcbB";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль должен содержать хотя бы одну цифру";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasNoUpperCase() {
        String password = "abacb5cbc";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль должен содержать хотя бы один символ в верхнем регистре";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasNoLowerCase() {
        String password = "ABACB5!554";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль должен содержать хотя бы один символ в нижнем регистре";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasWhiteSpace() {
        String password = "A BacB5!554";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль не должен содержать пробелов";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasNoSpecialCase() {
        String password = "ABacB5G554";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль должен содержать хотя бы один специальный символ";
        assertEquals(rsl, expected);
    }

    @Test
    void whenHasIllegalSubString() {
        String password = "ABacB5G554!AdMin";
        String rsl = PasswordValidator.validate(password);
        String expected = "Нельзя использовать варианты слов - admin, user, 12345, password";
        assertEquals(rsl, expected);
    }

}