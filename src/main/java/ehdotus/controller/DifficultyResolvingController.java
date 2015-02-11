package ehdotus.controller;

import ehdotus.domain.DifficultyData;
import ehdotus.repository.DifficultyDataRepository;
import ehdotus.services.DifficultyEstimatorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/difficulty")
public class DifficultyResolvingController {

    @Autowired
    private DifficultyDataRepository difficultyRepository;

    @Autowired
    private DifficultyEstimatorService estimatorService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DifficultyData> getDifficulties() {
        return difficultyRepository.findAll();
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public List<DifficultyData> getDifficulties(String userId) {
        return difficultyRepository.findByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void estimate(DifficultyData difficulty) {
        estimatorService.estimateDifficulty(difficulty);
    }
}
