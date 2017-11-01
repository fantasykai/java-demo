package com.fantasykai.java.base;

import java.util.Scanner;

/**
 * The type Lottery odds.
 */
public class LotteryOdds {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(" How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println(" what is the highest numbers you can do draw? ");
        int n = in.nextInt();

        int lotteryOdds = 1;

        for (int i =1; i<=k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;

            System.out.println("Your odds are 1 in " + lotteryOdds + " . Good luck!");
        }

    }



}
