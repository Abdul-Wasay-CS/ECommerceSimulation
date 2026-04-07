package pakMart;

public class Electronics extends Product {
    private int warranty;
    private String brand;
    private String power;

    public Electronics() {
        super();
        this.warranty = 0;
        this.brand = "Null";
        this.power = "Null";
    }

    public Electronics(int productId, String name, double price, int stock,
                       int warranty, String brand, String power) {
        super(productId, name, price, stock);
        this.warranty = warranty;
        this.brand = brand;
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Warranty: " + warranty +
                ", Brand: " + brand +
                ", Power: " + power;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        if (warranty >= 0)
            this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}