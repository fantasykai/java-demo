package lockstest;

/**
 * The type Transfer test.
 */
public class TransferTest {
    /**
     * The constant NACCOUNTS.
     */
    public static final int NACCOUNTS = 100;
    /**
     * The constant INITIAL_BALANCE.
     */
    public static final double INITIAL_BALANCE = 1000000;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
