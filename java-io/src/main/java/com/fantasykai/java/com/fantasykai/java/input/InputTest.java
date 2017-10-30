package com.fantasykai.java.com.fantasykai.java.input;

import java.util.Scanner;

/**
 * The type Input test.
 */
public class InputTest {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(" What is your name? ");
        String name = in.nextLine();

        System.out.println(" How old are you? ");

        int age = in.nextInt();

        System.out.println(" Hello," + name + ". Next year, you'll be " + (age + 1));

    }

}
