package ehdotus.estimators;

import ehdotus.domain.DifficultyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shemmink on 15.2.2015.
 */
@Component
public class EnsemblePredict {

    @Autowired
    private ReadClassifiersFromFile classifierReader;

    // PRIVATE FIELDS
    WeakClassifier[] weakClassifiers;

    // Perform ensemble predict based on the weakClassifiers
    public double[] classify(DifficultyData data) {
        if (weakClassifiers == null) {
            this.weakClassifiers = this.classifierReader.loadClassifiers();
        }

        int ensembleSize = WeakClassifier.ensembleSize();
        int classCount = WeakClassifier.getClassNames().length;
        double[] pdfWeightSum = new double[classCount];
        double[] pdf = new double[classCount];
        double weightSum = 0;

        // Loop through weak classifiers
        for (int i = 0; i < ensembleSize; i++) {

            // Get classification from a weak classifier
            double[] weakPdf = getWeakClassification(weakClassifiers[i]);
            double weight = weakClassifiers[i].getWeight();
            weightSum += weight;

            // Scale by weight and add to cumulative pdf
            for (int j = 0; j < classCount; j++) {
                pdfWeightSum[j] += weakPdf[j] * weight;
            }

        }

        // Normalize
        for (int i = 0; i < classCount; i++) {
            pdf[i] = pdfWeightSum[i] / weightSum;
        }

        // Reduce pdfOffset and re-normalize
        double pdfOffset = WeakClassifier.getPDFOffset();
        for (int i = 0; i < classCount; i++) {
            pdf[i] = (pdf[i] - pdfOffset) / (1 - classCount * pdfOffset);
        }

        // do something with the real value
        String secondsSpentOn = data.getContent().get("SECONDS_SPENT_ON");
        
        return pdf;
    }

    // Set weakLearners. Must be done before performing classify() function
    public void setEnsemble(WeakClassifier[] weakClassifier) {
        this.weakClassifiers = weakClassifier;
    }

    // Return classification result(pdf) from a weakClassifier
    private double[] getWeakClassification(WeakClassifier weakClassifier) {

        String featureName = weakClassifier.getFeatureName();
        double[] pdf = new double[3];
        double featureValue = Features.getFeatureValueByName(featureName);

        if (featureValue > weakClassifier.getCutPoint()) {
            return weakClassifier.getRightBranch();
        } else {
            return weakClassifier.getLeftBranch();
        }

    }
}
