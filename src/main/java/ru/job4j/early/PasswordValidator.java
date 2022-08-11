package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    "Пароль не может содержать значение null"
            );
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "Длина пароля не находится в диапазоне [8, 32]"
            );
        }

        if (!hasDigit(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы одну цифру"
            );
        }

        if (!hasUpperCase(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один символ в верхнем регистре"
            );
        }

        if (!hasLowerCase(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один символ в нижнем регистре"
            );
        }

        if (hasWhiteSpace(password)) {
            throw new IllegalArgumentException(
                    "Пароль не должен содержать пробелов"
            );
        }

        if (hasSpecialCase(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один специальный символ"
            );
        }

        if (hasInvalidSubString(password)) {
            throw new IllegalArgumentException(
                    "Нельзя использовать варианты слов - admin, user, 12345, password"
            );
        }

        return "Пароль соответствует условиям";
    }

    private static boolean hasDigit(String password) {
        boolean rsl = false;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (Character.isDigit(code)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean hasSpecialCase(String password) {
        boolean rsl = true;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if ((code > 32 && code < 48)
                || (code > 57 && code < 65)
                || (code > 90 && code < 97)
                || (code > 122 && code < 127)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    private static boolean hasUpperCase(String password) {
        boolean rsl = false;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (Character.isUpperCase(code)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean hasLowerCase(String password) {
        boolean rsl = false;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (Character.isLowerCase(code)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean hasWhiteSpace(String password) {
        boolean rsl = false;
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (Character.isWhitespace(code)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean hasInvalidSubString(String password) {
        return password.toLowerCase().contains("qwerty")
                || password.contains("12345")
                || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("user");
    }
}