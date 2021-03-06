package crk.interview.xmens.stat.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stat {

    private int countMutantDna;

    private int countHumanDna;

    private double ratio;

    public Stat(int countMutantDna, int countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
    }

    public void calculateRatio() {

        if (countHumanDna == 0) {
            ratio = 0.0;
        }else{
            ratio = (double) countMutantDna / (double) countHumanDna;
        }
    }


}
