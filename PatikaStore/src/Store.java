import java.util.ArrayList;
import java.util.List;
public class Store {
    private List<Product> products = new ArrayList<>();
    private List<Brand> brands = new ArrayList<>();

    // Constructor
    public Store() {
        products = new ArrayList<>();
        brands = new ArrayList<>();
        initializeBrands();

    }

    private void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }


    public void addProduct(Product product) {//+
        products.add(product);
    }

    public void listProducts() { //++
        for (Product product : products) {
            product.display();
        }
    }
    public void addBrand(Brand brand) {//+
        brands.add(brand);
    }


    public void deleteProduct(int productId) {//+
        products.removeIf(product -> product.getId() == productId);
    }

    public void listBrands() {//++
        brands.sort(Brand::compareTo);
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }
    }
    public void listProductsByCategory(Class<?> categoryClass) {//++
        for (Product product : products) {
            if (categoryClass.isInstance(product)) {
                product.display();
            }
        }
    }
    public void listProductsByBrand(String brandName) {
        for (Product product : products) {
            if (product.getBrand().getName().equalsIgnoreCase(brandName)) {
                product.display();
            }
        }
    }
    public void listProductsByPriceRange(double minPrice, double maxPrice) {
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                product.display();
            }
        }
    }
    public void listProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.display();
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }
    public Brand findBrandByName(String brandName) {
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                return brand;
            }
        }
        return null; // Eşleşen marka bulunamazsa null döndür
    }
    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Eşleşen ürün bulunamadı
    }

}
