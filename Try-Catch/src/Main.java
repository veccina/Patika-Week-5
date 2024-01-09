import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 10 elemanlı bir dizi tanımladık.
        int[] array = {15, 79, 33, 27, 44, 1, 7, 65, 18, 81};
        // Kullanıcıdan bir index değeri istenir.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a index: ");
        int index = scanner.nextInt();
        try {
            // getElementByIndex metodu kullanılarak dizinin belirli bir indeksindeki elemanı alıyoruz.
            int value = getElementByIndex(array, index);
            // Alınan eleman ekrana yazdırılır.
            System.out.println("Value of index " + index + " is " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Eğer indeks dizinin sınırları dışında ise hata mesajı görüntülenir.
            System.out.println("Error!! Invalid index. Please enter a index from 0 to 9.");
        }
    }

    // Dizinin belirli bir indeksindeki elemanı döndüren metot.
    public static int getElementByIndex(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // İstenen indeksteki elemanı geri döndürüyoruz.
        return array[index];
    }
}