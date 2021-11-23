package crk.interview.xmens.stat.infra.entry_point;

import crk.interview.xmens.dna.infra.events.SenderDna;
import crk.interview.xmens.stat.application.StatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/adns")
public class StatController {

    private final StatService statService;
    private static final Logger logger = LoggerFactory.getLogger(SenderDna.class);

    @Autowired
    public StatController(StatService statService) {
        this.statService = statService;
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats() {

        return ResponseEntity.ok(statService.getStatDnaAnalysis());
    }

}
