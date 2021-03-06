package crk.interview.xmens.dna.infra.entry_point;

import crk.interview.xmens.dna.application.DnaService;
import crk.interview.xmens.dna.infra.entry_point.request.DnaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("v1/adns")
public class DnaController {

    private final DnaService mutantService;


    @Autowired
    public DnaController(DnaService dnaService) {
        this.mutantService = dnaService;
    }

    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody DnaRequest validMutantRequest) {

        int idAdn = Arrays.deepHashCode(validMutantRequest.getAdn());
        HttpStatus responseStatus = mutantService.isMutant(idAdn, validMutantRequest.toAdn())
                ? HttpStatus.OK : HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(responseStatus);
    }
}
