package com.company;

import java.io.IOException;

public class WrongPasswordException extends IOException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
