
package ehdotus.services;

import ehdotus.domain.DifficultyData;
import org.springframework.stereotype.Service;

@Service
public class DifficultyEstimatorService {
    
    
    public void estimateDifficulty(DifficultyData data) {
        // TODO: estimator :D
        data.setEstimatedDifficulty(4);
    }
}
