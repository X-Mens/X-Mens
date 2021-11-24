package crk.interview.xmens.dna.domain;

import crk.interview.xmens.dna.domain.model.Dna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static crk.interview.xmens.share.domain.model.DnaType.HUMAN;
import static crk.interview.xmens.share.domain.model.DnaType.MUTANT;


class DnaDomainModelTest {

    @Test
    void shouldBeDnaMutantIfThereAreTwoSequenceOfFourCharacterWithTheSameLetter() {

        String[] dnaArray = new String[]{
                "TTTT",
                "TAGC",
                "TAGC",
                "TAGC",
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveHorizontal() {

        String[] dnaArray = new String[]{
                "TTTTT",
                "TAGCC",
                "CAGCC",
                "TAGCC",
                "TAGCG"
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveVertical() {

        String[] dnaArray = new String[]{
                "TGCTG",
                "TAGCC",
                "TAGTC",
                "TAGCC",
                "TAGCG"
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveOblique() {

        String[] dnaArray = new String[]{
                "TGCTG",
                "ATGCC",
                "TATGC",
                "TAGTC",
                "TAGCT"
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeDnaMutantIfThereAreTwoSequenceOnDifferentParts() {

        String[] dnaArray = new String[]{
                "TATGCTATGC",
                "TGATGCTATGC",
                "TAGTCTATGC",
                "GAGCTTATGC",
                "TGCGCTGTGT",
                "ATGCCAGCTG",
                "TATGCTATGC",
                "TAGTCTATGC",
                "TAGCTTATGC",
                "ATGCCTGCTC"
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeHumanDnaIfThereIsNotSequence() {

        String[] dnaArray = new String[]{
                "TAGCT",
                "AGCTT",
                "GCTTA",
                "CTTAG",
                "CTTAG",
        };
        Dna dna = new Dna(dnaArray);
        Assertions.assertEquals(HUMAN, dna.isMutant());
    }

    @Test
    void exampleTest() {
        String[] exampleTest = new String[]{
            "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"
        };
        Dna dna = new Dna(exampleTest);
        Assertions.assertEquals(MUTANT, dna.isMutant());
    }

    @Test
    void shouldBeHumanDnaIfNIsTwo() {
        String[] exampleTest = new String[]{"AT", "CA"};
        Dna dna = new Dna(exampleTest);
        Assertions.assertEquals(HUMAN, dna.isMutant());
    }

    @Test
    void shouldBeHumanDnaIfNIsThree() {
        String[] exampleTest = new String[]{"ATA", "CAA", "CCA"};
        Dna dna = new Dna(exampleTest);
        Assertions.assertEquals(HUMAN, dna.isMutant());
    }

    @Test
    void shouldBeHumanDnaIfNIsOne() {
        String[] exampleTest = new String[]{"A"};
        Dna dna = new Dna(exampleTest);
        Assertions.assertEquals(HUMAN, dna.isMutant());
    }

    @Test
    void shouldBeHumanDna() {
        String[] exampleTest = new String[]{
            "AAGGTTCC",
            "AAGGTTCC",
            "AAGGTTCC",
            "CCTTGGAA",
            "CCTTGTAA",
            "CCTTAAGG",
            "TTCCGGAA",
            "TTCCGGAA"
        };
        Dna dna = new Dna(exampleTest);
        Assertions.assertEquals(HUMAN, dna.isMutant());
    }



}
