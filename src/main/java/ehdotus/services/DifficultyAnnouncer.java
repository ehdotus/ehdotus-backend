package ehdotus.services;

import ehdotus.domain.DifficultyData;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DifficultyAnnouncer {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 10000)
    public void publishSomething() {
        DifficultyData dd = new DifficultyData();
        dd.setEstimatedDifficulty(new Random().nextInt(6));
        dd.setRealDifficulty(new Random().nextInt(6));
        
        this.template.convertAndSend("/results", dd);
    }

    public void announce(DifficultyData data) {
        this.template.convertAndSend("/results", data);
    }

}
