package com.company;

public class Main {

    public static void main(String[] args) {

        boolean example = Validator.check("hello_kitty", "hello12", "hello12");
        if (example) {
            System.out.println("Всё ок");
        } else {
            System.out.println("Это не очень, попробуй ещё раз :)");
        }
    }

}
