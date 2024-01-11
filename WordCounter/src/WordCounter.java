import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class WordCounter {

    public static void runWordCounter(String text) {
        //Kelimeleri ayırıp boşluklara göre bölüyoruz.
        String[] words = text.split(" ");
        // Kelimeleri ve sayılarını saklamak için bir HashMap kullanıyoruz.
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            // Kelimeyi küçük harfe çevirip gereksiz karakterleri temizliyoruz.
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            // Eğer kelime boşsa veya sadece işaretlerden oluşuyorsa atlıyoruz.
            if (word.isEmpty()) {
                continue;
            }
            // Kelimenin sayısını arttırıyoruz ya da ekliyoruz.
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // En çok geçen kelimeyi ve sayısını buluruz
        String mostFrequentWord = "";
        int mostFrequentCount = 0;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > mostFrequentCount) {
                mostFrequentWord = entry.getKey();
                mostFrequentCount = entry.getValue();
            }
        }
        if (!mostFrequentWord.isEmpty()) {
            System.out.println("Most frequent word: " + mostFrequentWord);
            System.out.println("Count: " + mostFrequentCount);
        } else {
            System.out.println("No valid word found in the text.");
        }
    }
}

