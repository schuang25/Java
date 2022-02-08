public class BaristaTest {
    public static void main(String[] args) {
        Order guest1 = new Order();
        Order guest2 = new Order();
        
        Order order1 = new Order("order1");
        Order order2 = new Order("order2");
        Order order3 = new Order("order3");

        Item item1 = new Item("drop coffee", 1.50);
        Item item2 = new Item("cappuccino", 3.50);
        Item item3 = new Item("latte", 2.50);

        guest1.addItem(item1);
        guest1.addItem(item3);
        guest2.addItem(item2);
        guest2.addItem(item2);
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item3);
        order3.addItem(item1);
        order3.addItem(item2);
        order3.addItem(item3);

        guest1.setReady(true);
        order2.setReady(true);
        System.out.println(guest1.getStatusMessage());
        System.out.println(order1.getStatusMessage());

        System.out.println(order3.getOrderTotal());

        guest1.display();
        guest2.display();
        order1.display();
        order2.display();
        order3.display();
    }
}
