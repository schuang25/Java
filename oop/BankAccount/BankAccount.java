import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int numAccounts = 0;
    private static double totalMoney = 0.0;

    public BankAccount() {
        checkingBalance = 0.0;
        savingsBalance = 0.0;
        accountNumber = generateAccountNumber();
        numAccounts++;
    }

    public double getCheckingBalance() { return checkingBalance; }

    public double getSavingsBalance() { return savingsBalance; }

    public static int getNumberOfAccounts() { return numAccounts; }
    
    public static double getTotalMoney() { return totalMoney; }

    public String getAccountNumber() { return accountNumber; }
    
    public void depositIntoChecking(double money) {
        checkingBalance += money;
        totalMoney += money;
    }

    public void depositIntoSavings(double money) {
        savingsBalance += money;
        totalMoney += money;
    }

    public void withdrawFromChecking(double money) {
        if (checkingBalance >= money) {
            checkingBalance -= money;
            totalMoney -= money;
        } else
            System.out.println("Not enough money in the account");
    }

    public void withdrawFromSavings(double money) {
        if (savingsBalance >= money) {
            savingsBalance -= money;
            totalMoney -= money;
        } else
            System.out.println("Not enough money in the account");
    }

    private String generateAccountNumber() { 
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random rand = new Random();
        String accNum = "";
        accNum += numbers[rand.nextInt(9) + 1];
        for (int i = 1; i < 10; i++) {
            accNum += numbers[rand.nextInt(10)];
        }
        return accNum;
    }
}
