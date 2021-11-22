package crk.interview.xmens.infra.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class DnaAnalysisModel {

    private String type;
    private String adnState;
    private String adnId;

    @Override
    public String toString() {
        return "DnaAnalysisModel{" +
                "type='" + type + '\'' +
                ", adnState='" + adnState + '\'' +
                ", adnId='" + adnId + '\'' +
                '}';
    }
}
