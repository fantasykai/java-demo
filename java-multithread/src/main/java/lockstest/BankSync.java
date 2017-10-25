package lockstest;

/**
 * The type Bank sync.
 */
public class BankSync {

    private final double[] accouts;

    /**
     * Instantiates a new Bank sync.
     *
     * @param n              the n
     * @param initialBalance the initial balance
     */
    public BankSync(int n, double initialBalance) {
        accouts = new double[n];
        // 每个账户的初始化金额
        for (int i = 0; i < accouts.length; i++) {
            accouts[i] = initialBalance;
        }
    }

    /**
     * Transfer.
     *
     * @param from   the from
     * @param to     the to
     * @param amount the amount
     * @throws InterruptedException the interrupted exception
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {

        while (accouts[from] < amount) {
            wait();
        }
        System.out.println(Thread.currentThread());
        accouts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accouts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /**
     * Gets total balance.
     *
     * @return the total balance
     */
    public synchronized double getTotalBalance() {
        double sum = 0;

        for (double a : accouts) {
            sum += a;
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
