package ehdotus.services;

import ehdotus.domain.DifficultyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class DifficultyAnnouncer {

    @Autowired
    private SimpMessagingTemplate template;

    public void announce(DifficultyData data) {
        this.template.convertAndSend("/results", data);
    }
}
