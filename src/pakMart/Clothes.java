package pakMart;

public class Clothes extends Product {
    private String size;
    private String brand;
    private String stuff;
    private String color;

    public Clothes() {
        super();
    }

    public Clothes(int productId, String name, double price, int stock,
                   String size, String brand, String stuff, String color) {
        super(productId, name, price, stock);
        this.size = size;
        this.brand = brand;
        this.stuff = stuff;
        this.color = color;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Size: " + size +
                "Brand: " + brand +
                "Stuff: " + stuff +
                "Color: " + color;
    }
}