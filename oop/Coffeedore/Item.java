public class Item {
    private int index;
    private String name;
    private double price;

    public Item(int index, String name, double price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    public int getIndex() { return index; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setIndex(int index) { this.index = index; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }
}
