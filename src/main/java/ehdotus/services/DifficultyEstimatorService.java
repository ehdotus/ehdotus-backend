
package ehdotus.services;

import ehdotus.domain.DifficultyData;
import ehdotus.repository.DifficultyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DifficultyEstimatorService {
    
    @Autowired
    private DifficultyAnnouncer announcer;
    
    @Autowired 
    private DifficultyDataRepository dataRepository;
    
    @Async
    public void estimateDifficulty(DifficultyData data) {
        // TODO: estimator :D
        data.setEstimatedDifficulty(4);
        
        // storing difficulty
        data = dataRepository.save(data);
        
        // announcing result
        announcer.announce(data);
    }
}
