import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    private List<String> teams; // Takım isimlerini tutacak olan List veri yapısı.
    private List<String[]> fixtures; // Fikstürü tutacak olan List veri yapısı.

    public FixtureGenerator(List<String> teams) {// Kurucu method, takım listesini alır.
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public void generateFixtures() { // Fikstürü oluşturan method.
        if (teams.size() % 2 != 0) {
            teams.add("Bay"); // takım sayısı tekse bay olacak takıma karşı bay yazdırıyoruz.
        }

        int numTeams = teams.size();// Takım sayısını elde ettiğimiz yer
        int numRounds = numTeams - 1;

        for (int roundNum = 1; roundNum <= numRounds; roundNum++) {
            List<String[]> roundFixtures = new ArrayList<>();

            if (roundNum % 2 == 0) { //çift tur
                roundFixtures.add(new String[]{teams.get(0), teams.get(numTeams - 1)});
                for (int i = 1; i < numTeams / 2; i++) {
                    roundFixtures.add(new String[]{teams.get(i), teams.get(numTeams - i - 1)});
                }
            } else { //tek tur
                for (int i = 0; i < numTeams / 2; i++) {
                    roundFixtures.add(new String[]{teams.get(i), teams.get(numTeams - i - 1)});
                }
            }

            fixtures.addAll(roundFixtures);// Bu turun fikstürünü ana fikstür listesine ekler.

            // Rotate teams for the next round
            Collections.rotate(teams.subList(1, numTeams), 1);
        }
    }

    public void displayFixtures() {// Fikstürü ekrana yazdıran method.
        int roundNum = 1;
        for (String[] fixture : fixtures) {
            System.out.println(roundNum + ". hafta");
            roundNum++;

            System.out.println(fixture[0] + " vs " + fixture[1]);
            System.out.println();
        }
    }
}