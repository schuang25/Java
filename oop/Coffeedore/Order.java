import java.util.ArrayList;

public class Order {
    private String name;
    private boolean isReady;
    private ArrayList<Item> items;

    public Order() {
        name = "Guest";
        items = new ArrayList();
    }

    public Order(String name) {
        this.name = name;
        items = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public boolean getReady() {
        return isReady;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        return isReady ? "Your order is ready" : "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal() {
        double sum = 0.0;
        for (Item item : items)
            sum += item.getPrice();
        return sum;
    }

    public void display() {
        System.out.println("Customer Name: " + name);
        for (Item item : items)
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
    }
}
