package pakMart;

public class Grocery extends Product {
    private String expiryDate;
    private double weight;
    private String brand;

    public Grocery() {
        super();
        this.expiryDate = "Null";
        this.weight = 0.0;
        this.brand = "Null";
    }

    public Grocery(int productId, String name, double price, int stock,
                   String expiryDate, double weight, String brand) {
        super(productId, name, price, stock);
        this.expiryDate = expiryDate;
        this.weight = weight;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Expiry Date: " + expiryDate +
                ", Weight: " + weight +
                ", Brand: " + brand;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0)
            this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}