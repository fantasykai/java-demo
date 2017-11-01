package com.fantasykai.java.base;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * The type Biglnteger test.
 * 彩概率程序的改进，
 * 使其可以采用大数值进行运算。
 * 假设你被邀请参加抽奖活动， 并从 490 个可能的数值中抽取 60 个，
 * 这个程序将会得到中彩
 * 概率 1/71639584346199555741511622254009293341171761278926349349335101345948110466 8848。
 * 祝你好运!
 */
public class BiglntegerTest {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("what is the highest number you can draw? ");
        int n = in.nextInt();

        /**
         * compute binomial coefficient
         */
        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));

            System.out.println("Your odds are 1 in " + lotteryOdds + " . Good luck!");
        }

    }


}
