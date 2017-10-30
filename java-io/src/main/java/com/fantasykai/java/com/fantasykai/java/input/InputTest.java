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

        System.out.println(" 您的姓名 ");
        String name = in.nextLine();

        System.out.println(" 您的工号 ");

        int jobNumber = in.nextInt();

        System.out.println(" 您好,工号为 " + jobNumber + " 的 " + name + "，（先生／女士），这是您的证件");

    }

}
