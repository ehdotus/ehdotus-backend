package ehdotus.controller;

import ehdotus.domain.Difficulty;
import ehdotus.repository.DifficultyRepository;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/difficulty")
public class DifficultyResolvingController {

    @Autowired
    private DifficultyRepository difficultyRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Difficulty> getDifficulties() {
        return difficultyRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Difficulty estimate(Difficulty difficulty) {
        // implement difficulty estimators here
        difficulty.setEstimatedDifficulty(new Random().nextInt(5) + 1);
        return difficultyRepository.save(difficulty);
    }
}
