public class Notebook extends Product {
    private int ram;
    private String storage;
    private double screenSize;

    // Constructor
    public Notebook(int id, double price, double discountRate, int stockAmount, String name, Brand brand, int ram, String storage, double screenSize) {
        super(id, price, discountRate, stockAmount, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    // Getters


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void display() {
        System.out.format("| %d | %s | %.2f TL | %s | %s | %.1f inch | %d GB RAM |\n",
                getId(), getName(), getPrice(), getBrand().getName(), getStorage(), getScreenSize(), getRam());
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + getId() +
                ", price=" + getPrice() +
                ", discountRate=" + getDiscountRate() +
                ", stockAmount=" + getStockAmount() +
                ", name='" + getName() + '\'' +
                ", brand=" + getBrand().getName() +
                ", ram=" + ram +
                ", storage='" + storage + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
