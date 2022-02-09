public class CoffeedoreTest {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();
        kiosk.addMenuItem("banana", 2.0);
        kiosk.addMenuItem("coffee", 1.5);
        kiosk.addMenuItem("latte", 3.5);
        kiosk.addMenuItem("capuccino", 3.0);
        kiosk.addMenuItem("muffin", 4.0);
        kiosk.displayMenu();
        kiosk.newOrder();
    }
}
