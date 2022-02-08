import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "item 1";
        item1.price = 3.34;

        Item item2 = new Item();
        item2.name = "item 2";
        item2.price = 3.75;
        
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "order 1";
        order1.ready = false;
        order1.items.add(item1);
        order1.items.add(item2);
        for (Item item : order1.items)
            order1.total += item.price;
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
