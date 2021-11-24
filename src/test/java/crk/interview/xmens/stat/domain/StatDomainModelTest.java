package crk.interview.xmens.stat.domain;

import crk.interview.xmens.stat.domain.model.Stat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatDomainModelTest {

    @Test
    void ratioShouldBeZeroWhenTheTwoCounterAreZero() {

        Stat stat = new Stat(0, 0);
        stat.calculateRatio();
        Assertions.assertEquals(stat.getRatio(), 0.0);
    }

    @Test
    void ratioShouldBeZeroWhenCountHumanIsZero() {

        Stat stat = new Stat(1010, 0);
        stat.calculateRatio();
        Assertions.assertEquals(stat.getRatio(), 0.0);
    }

    @Test
    void exampleTestPDF() {

        Stat stat = new Stat(40, 100);
        stat.calculateRatio();
        Assertions.assertEquals(stat.getRatio(), 0.4);
    }

}
