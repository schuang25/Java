public class BankTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();

        System.out.println(BankAccount.getNumberOfAccounts());
        acc1.depositIntoChecking(50.0);
        acc1.depositIntoSavings(100.0);
        acc2.depositIntoChecking(100.0);
        acc2.depositIntoSavings(25.0);
        acc1.withdrawFromChecking(30.0);
        acc2.withdrawFromSavings(50.0);
        System.out.println(BankAccount.getTotalMoney());
        System.out.println(acc1.getAccountNumber());
    }
}
