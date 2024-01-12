import java.util.Scanner;
public class Main {
    private static Store patikaStore = new Store();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSampleData();



        boolean running = true;
        while (running) {
            System.out.println("\nPatikaStore Ürün Yönetim Paneli");
            System.out.println("1 - Ürünleri Listele");
            System.out.println("2 - Ürün Ekle");
            System.out.println("3 - Ürün Sil");
            System.out.println("4 - Markaları Listele");
            System.out.println("5 - Kategoriye Göre Ürünleri Listele");
            System.out.println("6 - Markaya Göre Ürünleri Listele");
            System.out.println("7 - Fiyat Aralığına Göre Ürünleri Listele");
            System.out.println("8 - ID'ye Göre Ürün Listele");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminizi yapınız: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    patikaStore.listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    patikaStore.listBrands();
                    break;
                case 5:
                    listProductsByCategory();
                    break;
                case 6:
                    listProductsByBrand();
                    break;
                case 7:
                    listProductsByPriceRange();
                    break;
                case 8:
                    listProductById();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }


        private static void initializeSampleData () {
            Brand samsung = new Brand(1, "Samsung");
            Brand apple = new Brand(2, "Apple");
            Brand lenovo = new Brand(3, "Lenovo");
            Brand huawei = new Brand(4, "Huawei");
            Brand casper = new Brand(5, "Casper");
            Brand asus = new Brand(6, "Asus");
            Brand hp = new Brand(7, "HP");
            Brand xiaomi = new Brand(8, "Xiaomi");
            Brand monster = new Brand(9, "Monster");

            patikaStore.addBrand(samsung);
            patikaStore.addBrand(apple);
            patikaStore.addBrand(lenovo);
            patikaStore.addBrand(huawei);
            patikaStore.addBrand(casper);
            patikaStore.addBrand(asus);
            patikaStore.addBrand(hp);
            patikaStore.addBrand(xiaomi);
            patikaStore.addBrand(monster);

            patikaStore.addProduct(new Notebook(1, 7000, 10, 5, "HUAWEI Matebook 14", huawei, 16, "512GB SSD", 14));
            patikaStore.addProduct(new Notebook(2, 3699, 10, 5, "Lenovo V14 IGL", lenovo, 8, "1TB HDD", 14));
            patikaStore.addProduct(new Notebook(3, 8199, 10, 5, "ASUS Tuf Gaming", asus, 32, "2TB SSD", 15.6));

            patikaStore.addProduct(new CellPhone(4, 3199, 5, 10, "Samsung Galaxy A51", samsung, "128GB", 6.5, 4000, 6, "Black"));
            patikaStore.addProduct(new CellPhone(5, 7379, 5, 10, "iPhone 11 64GB", apple, "64GB", 6.1, 3046, 6, "Blue"));
            patikaStore.addProduct(new CellPhone(6, 4012, 5, 10, "Xiaomi Redmi Note 10 Pro 8GB", xiaomi, "128GB", 6.5, 4000, 12, "White"));
        }


        private static void addProduct () {
            System.out.println("Ürün tipini seçiniz (1: Notebook, 2: CellPhone): ");
            int productType = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ürün ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ürün Adı: ");
            String name = scanner.nextLine();

            System.out.print("Fiyat: ");
            double price = scanner.nextDouble();

            System.out.print("İndirim Oranı (%): ");
            double discountRate = scanner.nextDouble();

            System.out.print("Stok Miktarı: ");
            int stockAmount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Marka (Samsung, Apple, vb.): ");
            String brandName = scanner.nextLine();

            Brand brand = patikaStore.findBrandByName(brandName);
            if (brand == null) {
                System.out.println("Marka bulunamadı. Ürün eklenemedi.");
                return;
            }

            if (productType == 1) {
                // Notebook için ek özellikler
                System.out.print("RAM (GB): ");
                int ram = scanner.nextInt();

                System.out.print("Depolama (GB): ");
                String storage = scanner.next();

                System.out.print("Ekran Boyutu (Inç): ");
                double screenSize = scanner.nextDouble();
                Notebook newNotebook = new Notebook(id, price, discountRate, stockAmount, name, brand, ram, storage, screenSize);
                patikaStore.addProduct(newNotebook);
            } else if (productType == 2) {
                // CellPhone için ek özellikler
                System.out.print("Depolama (GB): ");
                String storage = scanner.next();

                System.out.print("Ekran Boyutu (Inç): ");
                double screenSize = scanner.nextDouble();

                System.out.print("Pil Gücü (mAh): ");
                int batteryPower = scanner.nextInt();

                System.out.print("RAM (GB): ");
                int ram = scanner.nextInt();
                scanner.nextLine(); // Buffer'ı temizle

                System.out.print("Renk: ");
                String color = scanner.nextLine();

                CellPhone newCellPhone = new CellPhone(id, price, discountRate, stockAmount, name, brand, storage, screenSize, batteryPower, ram, color);
                patikaStore.addProduct(newCellPhone);
                System.out.println(name + " adlı cep telefonu eklendi.");
            } else {
                System.out.println("Geçersiz ürün tipi. Ürün eklenemedi.");
            }

        }

        private static void deleteProduct () {
            System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Buffer'ı temizle

            // Ürünün varlığını kontrol et ve sil
            Product product = patikaStore.findProductById(productId);
            if (product != null) {
                patikaStore.deleteProduct(productId);
                System.out.println(productId + " ID'li ürün silindi.");
            } else {
                System.out.println(productId + " ID'li bir ürün bulunamadı.");
            }
        }

        private static void listProductsByCategory () {
            System.out.println("Listelenecek ürün kategorisini seçiniz (1: Notebook, 2: CellPhone): ");
            int categoryChoice = scanner.nextInt();
            scanner.nextLine(); // Buffer'ı temizle

            if (categoryChoice == 1) {
                System.out.println("Notebook Kategorisindeki Ürünler:");
                patikaStore.listProductsByCategory(Notebook.class);
            } else if (categoryChoice == 2) {
                System.out.println("CellPhone Kategorisindeki Ürünler:");
                patikaStore.listProductsByCategory(CellPhone.class);
            } else {
                System.out.println("Geçersiz kategori. Lütfen tekrar deneyin.");
            }
        }
        private static void listProductsByBrand () {
            System.out.print("Listelemek istediğiniz marka adını giriniz: ");
            String brandName = scanner.nextLine();

            System.out.println(brandName + " Markasına Ait Ürünler:");
            patikaStore.listProductsByBrand(brandName);
        }

        private static void listProductsByPriceRange () {
            System.out.print("Minimum fiyatı giriniz: ");
            double minPrice = scanner.nextDouble();

            System.out.print("Maksimum fiyatı giriniz: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine(); // Buffer'ı temizle

            System.out.println("Fiyat Aralığı " + minPrice + " - " + maxPrice + " arasındaki Ürünler:");
            patikaStore.listProductsByPriceRange(minPrice, maxPrice);
        }
        private static void listProductById () {
            System.out.print("Listelemek istediğiniz ürünün ID'sini giriniz: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Buffer'ı temizle

            Product product = patikaStore.findProductById(productId);
            if (product != null) {
                System.out.println("ID: " + product.getId());
                System.out.println("Ad: " + product.getName());
                System.out.println("Marka: " + product.getBrand());
                System.out.println("Fiyat: " + product.getPrice());
            } else {
                System.out.println(productId + " ID'li bir ürün bulunamadı.");
            }
        }
    }
