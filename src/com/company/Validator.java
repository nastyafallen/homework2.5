package com.company;

import java.util.Objects;

public class Validator {
    private static final String VALID_SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";

    private Validator() {
    }

    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException a) {
            System.out.println("Ошибка!");
            return false;
        }
    }

    public static void validate(String login,
                                String password,
                                String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20 || !useValidSymbols(login)) {
            throw new WrongLoginException("Ошибка! Использование недопустимых символов или превышение возможной длины логина");
        }
        if (Objects.isNull(password) || password.length() >= 20 || !useValidSymbols(password)) {
            throw new WrongPasswordException("Ошибка! Использование недопустимых символов или превышение возможной длины пароля");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не совпадают");
        }

    }

    private static boolean useValidSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return true;
    }

}
