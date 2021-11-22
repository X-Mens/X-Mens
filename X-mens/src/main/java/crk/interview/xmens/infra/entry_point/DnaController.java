package crk.interview.xmens.infra.entry_point;

import crk.interview.xmens.application.DnaService;
import crk.interview.xmens.domain.model.DnaType;
import crk.interview.xmens.infra.entry_point.request.DnaRequest;

import crk.interview.xmens.infra.events.SenderDna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/adns")
public class DnaController {

    private final DnaService mutantService;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);


    @Autowired
    public DnaController(DnaService dnaService) {
        this.mutantService = dnaService;
    }

    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody DnaRequest validMutantRequest){

        HttpStatus responseStatus = mutantService.isMutant(validMutantRequest.toAdn())
                ? HttpStatus.OK : HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(responseStatus);
    }

}
