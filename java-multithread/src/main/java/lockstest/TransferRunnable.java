package lockstest;

/**
 * The type Transfer runnable.
 */
public class TransferRunnable implements Runnable {
    private int fromAccount;
    private double maxAmout;
    private int DELAY = 10; // 延迟
    private Bank bank;

    /**
     * Instantiates a new Transfer runnable.
     *
     * @param bank        the bank
     * @param fromAccount the from account
     * @param maxAmout    the max amout
     */
    public TransferRunnable(Bank bank, int fromAccount, double maxAmout) {
        this.fromAccount = fromAccount;
        this.maxAmout = maxAmout;
        this.bank = bank;
    }

    @Override
    public void run() {

        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAmout * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }

        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}
