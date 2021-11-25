package crk.interview.xmens.dna.domain.model;

import crk.interview.xmens.share.domain.model.DnaType;

import java.util.Arrays;


public class Dna {

    private String[] adn;
    private final int adnSize;
    private final int[] dx = new int[]{1, 2, 3};
    private final int[] dy = new int[]{1, 2, 3};

    public Dna(String[] dna) {
        this.adn = dna;
        this.adnSize = dna.length;
    }

    public DnaType isMutant() {

        boolean isMutant = false;
        if (adnSize > 3) {
            int countSequenceSame = 0;
            for (int i = 0; i < adnSize && countSequenceSame < 2; i++) {
                for (int j = 0; j < adnSize && countSequenceSame < 2; j++) {
                    countSequenceSame += verifyHorizontal(i, j);
                    countSequenceSame += verifyVertical(i, j);
                    countSequenceSame += verifyOblique(i, j);
                }
            }
            isMutant = countSequenceSame >= 2;
        }
        return isMutant ? DnaType.MUTANT : DnaType.HUMAN;
    }

    private int verifyOblique(int x, int y) {
        char character = this.adn[x].charAt(y);
        boolean obliqueUp = true;
        boolean obliqueDown = true;
        for (int i = 1; i <= 3; i++) {
            obliqueUp &= isThereSequence(y - i >= 0 && x + i < adnSize, x + i, y - i, character);
            obliqueDown &= isThereSequence(y + i < adnSize && x + i < adnSize, x + i, y + i, character);
        }
        if (obliqueUp && obliqueDown) return 2;
        if (obliqueUp || obliqueDown) return 1;
        else return 0;
    }

    private boolean isThereSequence(boolean condition, int dx, int dy, char character) {
        boolean isThereSequence = true;
        if (condition) {
            char characterToCompare = this.adn[dx].charAt(dy);
            if (characterToCompare != character) {
                isThereSequence = false;
            }
        } else {
            isThereSequence = false;
        }
        return isThereSequence;
    }

    private int verifyVertical(int x, int y) {
        char character = this.adn[x].charAt(y);
        for (int i = 1; i <= 3; i++) {
            if (y + i >= adnSize)return 0;
            char characterToCompare = this.adn[x].charAt(y + i);
            if (characterToCompare != character) {
                return 0;
            }
        }
        return 1;
    }

    private int verifyHorizontal(int x, int y) {
        char character = this.adn[x].charAt(y);
        for (int i = 1; i <= 3; i++) {
            if (x + i >= adnSize)return 0;
            char characterToCompare = this.adn[x + i].charAt(y);
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
