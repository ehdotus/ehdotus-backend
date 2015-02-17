package ehdotus.estimators;

import ehdotus.domain.DifficultyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplemationUno implements Estimator {
    
    @Autowired
    private EnsemblePredict predictor;

    @Override
    public void estimateDifficulty(DifficultyData data) {
        // ...
    	
        // TODO: 
        
        predictor.classify(data);
        
        
        
    	// 2. User-Cluster specific classifier
    	// - Get userID and associate with a cluster
    	// - Load cluster-specific classifier from file & predict
    	
    	
    	
    	
    }
    
}
