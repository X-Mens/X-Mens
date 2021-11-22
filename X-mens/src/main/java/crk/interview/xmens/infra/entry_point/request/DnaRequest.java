package crk.interview.xmens.infra.entry_point.request;

import crk.interview.xmens.domain.model.Dna;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DnaRequest {

    @NotNull
    public String[] adn;

    public Dna toAdn() {

        return new Dna(adn);
    }
}
