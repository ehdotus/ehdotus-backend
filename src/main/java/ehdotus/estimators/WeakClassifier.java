package ehdotus.estimators;

/**
 * Created by shemmink on 15.2.2015.
 */
public class WeakClassifier {

    // Private fields
    private static int classifierCounter = 0;
    private static double pdf_offset;
    private static String[] classNames;
    private int classifierID;
    private String featureName;
    private double cutPoint, weight;
    private double[] leftBranch, rightBranch;

    // CONSTRUCTOR
    public WeakClassifier() {
        this.classifierID = classifierCounter;
        classifierCounter++;
    }

    // SETTERS
    public static void setPDFOffset(double offset) {
        pdf_offset = offset;
    }

    public static void setClassNames(String[] classes) {
        classNames = classes;
    }

    public void setFeature(String featureName) {
        this.featureName = featureName;
    }

    public void setCutPoint(double cutpoint) {
        this.cutPoint = cutpoint;
    }

    public void setLeftBranch(double[] pdf) {
        this.leftBranch = pdf;
    }

    public void setRightBranch(double[] pdf) {
        this.rightBranch = pdf;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // GETTERS
    public static String[] getClassNames() {
        return classNames;
    }

    public static double getPDFOffset() {
        return pdf_offset;
    }

    public static int ensembleSize() {
        return classifierCounter;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getCutPoint() {
        return this.cutPoint;
    }

    public double[] getLeftBranch() {
        return this.leftBranch;
    }

    public double[] getRightBranch() {
        return this.rightBranch;
    }

    @Override
    public String toString() {

        String returnable = "Weak Classifier ID: " + this.classifierID + "\n" + "IF " + this.featureName + "<(" + this.cutPoint + "): \n";

        for (int i = 0; i < this.classNames.length; i++) {
            returnable = returnable + this.classNames[i] + ": " + this.leftBranch[i] + "\n";
        }

        returnable = returnable + "ELSE \n";

        for (int i = 0; i < this.classNames.length; i++) {
            returnable = returnable + this.classNames[i] + ": " + this.rightBranch[i] + "\n";
        }

        return returnable;

    }
}
