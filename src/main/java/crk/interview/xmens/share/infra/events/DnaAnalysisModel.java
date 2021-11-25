package crk.interview.xmens.share.infra.events;

import crk.interview.xmens.share.domain.model.DnaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DnaAnalysisModel {

    private DnaType adnState;
    private int adnId;

    @Override
    public String toString() {
        return "DnaAnalysisModel{" +
                "adnState=" + adnState +
                ", adnId='" + adnId + '\'' +
                '}';
    }
}
