import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            List<String> teams1 = new ArrayList<>();
            teams1.add("Galatasaray");
            teams1.add("Bursaspor");
            teams1.add("Fenerbahçe");
            teams1.add("Beşiktaş");
            teams1.add("Başakşehir");
            teams1.add("Trabzonspor");

            List<String> teams2 = new ArrayList<>();
            teams2.add("Galatasaray");
            teams2.add("Bursaspor");
            teams2.add("Fenerbahçe");
            teams2.add("Beşiktaş");
            teams2.add("Başakşehir");
            teams2.add("Bursaspor");
            teams2.add("Boluspor");

            FixtureGenerator generator1 = new FixtureGenerator(teams1);
            generator1.generateFixtures();

            FixtureGenerator generator2 = new FixtureGenerator(teams2);
            generator2.generateFixtures();

            System.out.println("Takım sayısı çift fikstürü");
            generator1.displayFixtures();

            System.out.println("\nTakım sayısı tek fikstürü");
            generator2.displayFixtures();
        }
    }