package crk.interview.xmens.stat.infra.entry_point;

import crk.interview.xmens.stat.application.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/adns")
public class StatController {

    private final StatService statService;

    @Autowired
    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {

        return ResponseEntity.ok(statService.getStatDnaAnalysis());
    }

}
