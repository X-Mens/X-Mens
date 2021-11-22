package crk.interview.xmens.domain.model;

import java.util.Arrays;


public class Dna {

    private String[] adn;
    private final int adnSize;
    private final int[] dx = new int[]{-1, -2, -3};
    private final int[] dy = new int[]{-1, -2, -3};

    public Dna(String[] dna) {
        this.adn = dna;
        this.adnSize = dna.length;
    }

    public DnaType isMutant() {

        boolean isMutant = false;
        if (adnSize > 3) {
            int countSequenceSame = 0;
            for (int i = 3; i < adnSize && countSequenceSame < 2; i++) {
                for (int j = 3; j < adnSize; j++) {
                    countSequenceSame += verifyHorizontal(i, j);
                    countSequenceSame += verifyVertical(i, j);
                    countSequenceSame += verifyOblicua(i, j);
                }
            }
            isMutant = countSequenceSame >= 2;
        }
        return isMutant ? DnaType.MUTANT : DnaType.HUMAN;
    }

    private int verifyOblicua(int x, int y) {
        char character = this.adn[x].charAt(y);
        for (int i = 0; i < 3; i++) {
            char characterToCompare = this.adn[x + dx[i]].charAt(y + dy[i]);
            if (characterToCompare != character) {
                return 0;
            }
        }
        return 1;
    }

    private int verifyVertical(int x, int y) {
        char character = this.adn[x].charAt(y);
        for (int i = 0; i < 3; i++) {
            char characterToCompare = this.adn[x].charAt(y + dy[i]);
            if (characterToCompare != character) {
                return 0;
            }
        }
        return 1;
    }

    private int verifyHorizontal(int x, int y) {
        char character = this.adn[x].charAt(y);
        for (int i = 0; i < 3; i++) {
            char characterToCompare = this.adn[x + dx[i]].charAt(y);
            if (characterToCompare != character) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Dna{" +
                "adn=" + Arrays.toString(adn) +
                ", adnSize=" + adnSize +
                ", dx=" + Arrays.toString(dx) +
                ", dy=" + Arrays.toString(dy) +
                '}';
    }
}
