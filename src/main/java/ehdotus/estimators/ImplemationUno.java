package ehdotus.estimators;

import ehdotus.domain.DifficultyData;
import org.springframework.stereotype.Service;

@Service
public class ImplemationUno implements Estimator {

    @Override
    public void estimateDifficulty(DifficultyData data) {
        // ...
    	
    	
    	// 1. General classifier
    	// - Just load the classifier structure from file & predict
    	
    	// 2. User-Cluster specific classifier
    	// - Get userID and associate with a cluster
    	// - Load cluster-specific classifier from file & predict
    	
    	
    	
    	
    }
    
}
