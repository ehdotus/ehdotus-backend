package ehdotus.controller;

import ehdotus.repository.DifficultyDataRepository;
import ehdotus.services.DifficultyEstimatorService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DifficultyDataRepository difficultyRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getUsers() {
        return difficultyRepository.findAll()
                .parallelStream()
                .map((s) -> s.getUserId()).sorted().distinct()
                .collect(Collectors.toList());
    }
}
