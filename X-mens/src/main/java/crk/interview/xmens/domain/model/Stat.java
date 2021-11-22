package crk.interview.xmens.domain.model;


public class Stat {

    private int countMutantDna;

    private int countHumanDna;

    private double ratio;

    public Stat(int countMutantDna, int countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
    }

    public void calculateRatio(){

        if(countHumanDna == 0) {
            this.ratio = .0;
        }

        this.ratio = (double) countMutantDna/ (double) countHumanDna;
    }
}
