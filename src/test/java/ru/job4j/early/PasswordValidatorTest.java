package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null));
        assertEquals(exception.getMessage(),
                "Пароль не может содержать значение null");
    }

    @Test
    void whenInvalidLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("a1b2C3"));
        assertEquals(exception.getMessage(),
                "Длина пароля не находится в диапазоне [8, 32]");
    }

    @Test
    void whenHasNoDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("abacbcbB"));
        assertEquals(exception.getMessage(),
                "Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    void whenHasNoUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("abacb5cbc"));
        assertEquals(exception.getMessage(),
                "Пароль должен содержать хотя бы один символ в верхнем регистре");
    }

    @Test
    void whenHasNoLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("ABACB5!554"));
        assertEquals(exception.getMessage(),
                "Пароль должен содержать хотя бы один символ в нижнем регистре");
    }

    @Test
    void whenHasWhiteSpace() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("A BacB5!554"));
        assertEquals(exception.getMessage(),
                "Пароль не должен содержать пробелов");
    }

    @Test
    void whenHasNoSpecialCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("ABacB5G554"));
        assertEquals(exception.getMessage(),
                "Пароль должен содержать хотя бы один специальный символ");
    }

    @Test
    void whenHasIllegalSubString() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("ABacB5G554!AdMin"));
        assertEquals(exception.getMessage(),
                "Нельзя использовать варианты слов - admin, user, 12345, password");
    }

    @Test
    void whenValid() {
        String password = "ABacB5G554!An";
        String rsl = PasswordValidator.validate(password);
        String expected = "Пароль соответствует условиям";
        assertEquals(rsl, expected);
    }
}