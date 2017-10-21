package lockstest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Bank.
 */
public class Bank {

    // 账户数组
    private final double[] accouts;
    // 锁
    private Lock bankLock;
    // 条件：足够转账的资金
    private Condition sufficientFunds;

    /**
     * Instantiates a new Bank.
     *
     * @param n              the n
     * @param initialBalance the initial balance
     */
    public Bank(int n, double initialBalance) {
        accouts = new double[n];
        for (int i = 0; i < accouts.length; i++) {
            accouts[i] = initialBalance;
            bankLock = new ReentrantLock();
            sufficientFunds = bankLock.newCondition();
        }
    }

    /**
     * 实现转账
     *
     * @param from   the from
     * @param to     the to
     * @param amount the amount
     */
    public void transfer(int from, int to, double amount) {

        bankLock.lock();
        try {
            // 账户资金小于 转账金额时，等待打款
            while (accouts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accouts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accouts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();

        } catch (Exception e) {
            // 异常时，释放锁
            bankLock.unlock();
        }
    }

    /**
     * Gets total balance.
     *
     * @return total balance
     */
    public double getTotalBalance() {
        bankLock.lock();
        double sum = 0;
        try {
            for (double a : accouts) {
                sum += a;
            }
        } catch (Exception e) {
            bankLock.unlock();
        }
        return sum;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return accouts.length;
    }

}
