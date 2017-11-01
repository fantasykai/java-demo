package com.fantasykai.java.base;

import java.util.Scanner;

/**
 * The type Lottery odds.
 */
public class LotteryOdds {


    /**
     * The entry point of application.
     * <p>
     * for 循环的典型示例。 这个程序用来计算抽奖中奖的概率。
     * 例 如，如果必须从1 ~ 50之间的数字中取6个数字来抽奖，
     * 那么会有(50x49x48x47x46x45)/ (1 x 2 x 3 x 4 x 5 x 6) 种可能的结果，
     * 所以中奖的几率是 1/15 890700。祝你好运!
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

        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;

            System.out.println("Your odds are 1 in " + lotteryOdds + " . Good luck!");
        }

    }


}
