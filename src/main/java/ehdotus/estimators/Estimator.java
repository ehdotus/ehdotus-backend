package ehdotus.estimators;

import ehdotus.domain.DifficultyData;

public interface Estimator {
    void estimateDifficulty(DifficultyData data);
}
