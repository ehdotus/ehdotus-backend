
package ehdotus.services;

import ehdotus.domain.DifficultyData;
import ehdotus.estimators.Estimator;
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
    
    @Autowired
    private Estimator estimator;
    
    @Async
    public void estimateDifficulty(DifficultyData data) {
        
        estimator.estimateDifficulty(data);
        
        // storing difficulty
        data = dataRepository.save(data);
        
        // announcing result
        announcer.announce(data);
    }
}
