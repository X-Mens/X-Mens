package crk.interview.xmens.dna.domain;

import crk.interview.xmens.dna.domain.model.Dna;
import crk.interview.xmens.share.domain.model.DnaType;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static crk.interview.xmens.share.domain.model.DnaType.HUMAN;
import static crk.interview.xmens.share.domain.model.DnaType.MUTANT;


@RunWith(Parameterized.class)
public class DnaModelTest {

    @Parameter
    public String[] dna;

    @Parameter(1)
    public DnaType type;

    @Parameter(2)
    public String message;

    @Test
    public void checkIfDnaIsMutantOrNot() {

        Dna dnaTest = new Dna(dna);
        Assertions.assertEquals(type, dnaTest.isMutant());
    }

    @Parameters(name = "{2}")
    public static Collection testCases() {
        return Arrays.asList(new Object[][]{
                {new String[]{
                        "TTTT",
                        "TAGC",
                        "TAGC",
                        "TAGC"}, MUTANT, "shouldBeDnaMutantIfThereAreTwoSequenceOfFourCharacterWithTheSameLetter"},
                {new String[]{
                        "TTTTT",
                        "TAGCC",
                        "CAGCC",
                        "TAGCC",
                        "TAGCG"}, MUTANT, "shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveHorizontal"},
                {new String[]{
                        "TGCTG",
                        "TAGCC",
                        "TAGTC",
                        "TAGCC",
                        "TAGCG"}, MUTANT, "shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveVertical"},
                {new String[]{
                        "TGCTG",
                        "ATGCC",
                        "TATGC",
                        "TAGTC",
                        "TAGCT"}, MUTANT, "shouldBeDnaMutantIfThereAreMoreTheFourCharacterConsecutiveOblique"},
                {new String[]{
                        "TATGCTATGC",
                        "TGATGCTATGC",
                        "TAGTCTATGC",
                        "GAGCTTATGC",
                        "TGCGCTGTGT",
                        "ATGCCAGCTG",
                        "TATGCTATGC",
                        "TAGTCTATGC",
                        "TAGCTTATGC",
                        "ATGCCTGCTC"}, MUTANT, "shouldBeDnaMutantIfThereAreTwoSequenceOnDifferentParts"},
                {new String[]{
                        "ATGCGA",
                        "CAGTGC",
                        "TTATGT",
                        "AGAAGG",
                        "CCCCTA",
                        "TCACTG"}, MUTANT, "exampleTest"},
                {new String[]{
                        "TAGAT",
                        "AGCTT",
                        "GCTTA",
                        "CTTAG",
                        "CGTAG"}, HUMAN, "shouldBeHumanDnaIfThereIsNotSequence"},
                {new String[]{
                        "AT",
                        "CA"}, HUMAN, "shouldBeHumanDnaIfNIsTwo"},
                {new String[]{
                        "ATA",
                        "CAA",
                        "CCA"}, HUMAN, "shouldBeHumanDnaIfNIsThree"},
                {new String[]{
                        "A"}, HUMAN, "shouldBeHumanDnaIfNIsOne"},
        });
    }

}
