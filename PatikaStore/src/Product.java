public abstract class Product {
    private int id;
    private double price;
    private double discountRate;
    private int stockAmount;
    private String name;
    private Brand brand;

    public Product(int id, double price, double discountRate, int stockAmount, String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public abstract void display();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", discountRate=" + discountRate +
                ", stockAmount=" + stockAmount +
                ", name='" + name + '\'' +
                ", brand=" + brand.getName() +
                '}';
    }
}
