public class CellPhone extends Product {
    private String storage;
    private double screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public CellPhone(int id, double price, double discountRate, int stockAmount, String name, Brand brand, String storage, double screenSize, int batteryPower, int ram, String color) {
        super(id, price, discountRate, stockAmount, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }


    public String getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void display() {
        System.out.format("| %d | %s | %.2f TL | %s | %s | %.1f inch | %d mAh | %d GB RAM | %s |\n",
                getId(), getName(), getPrice(), getBrand().getName(), getStorage(), getScreenSize(), getBatteryPower(), getRam(), getColor());
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "id=" + getId() +
                ", price=" + getPrice() +
                ", discountRate=" + getDiscountRate() +
                ", stockAmount=" + getStockAmount() +
                ", name='" + getName() + '\'' +
                ", brand=" + getBrand().getName() +
                ", storage='" + storage + '\'' +
                ", screenSize=" + screenSize +
                ", batteryPower=" + batteryPower +
                ", ram=" + ram +
                ", color='" + color + '\'' +
                '}';
    }
}
