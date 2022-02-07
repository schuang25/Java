import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) 
            sum += i;
        return sum;
    }
    
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) 
            sum += i;
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0.0;
        for (int i = 0; i < prices.length; i++) 
            sum += prices[i];
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++)
            System.out.println(i + " " + menuItems.get(i));
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.print("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        if (customers.size() != 1)
            System.out.println("There are " + customers.size() + " people in front of you.");
        else
            System.out.println("There is " + customers.size() + " person in front of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}
