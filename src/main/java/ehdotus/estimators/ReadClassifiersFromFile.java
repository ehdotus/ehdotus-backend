package ehdotus.estimators;

/**
 * Created by shemmink on 15.2.2015.
 */

import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class ReadClassifiersFromFile {

	public static final String JSONFILENAME = "classifiers.json";
	
    public static WeakClassifier[] loadClassifiers() {

        JSONParser parser = new JSONParser();
        WeakClassifier[] returnable = null;

        try {

            // Read classifiers from JSON-file
            File jsonFile = new File(JSONFILENAME);
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonFile));

            double offset = ((Number)jsonObject.get("PDF_Offset")).doubleValue();
            WeakClassifier.setPDFOffset(offset);

            JSONArray trees = (JSONArray) jsonObject.get("trees");
            int numberOfTrees = trees.size();

            Iterator<JSONObject> treeIterator = trees.iterator();

            WeakClassifier[] weakClassifiers = new WeakClassifier[numberOfTrees];

            int i = 0;
            while (treeIterator.hasNext()) {

                JSONObject thisTree = treeIterator.next();
                WeakClassifier newWeakClassifier = new WeakClassifier();

                newWeakClassifier.setFeature((String) thisTree.get("feature"));
                newWeakClassifier.setCutPoint( ((Number)thisTree.get("threshold")).doubleValue() );
                newWeakClassifier.setWeight( ((Number)thisTree.get("weight")).doubleValue() );

                JSONObject branches = (JSONObject) thisTree.get("branch");
                JSONObject rightBranch = (JSONObject) branches.get("left");
                JSONObject leftBranch = (JSONObject) branches.get("right");

                Object[] classesObj = rightBranch.keySet().toArray();
                String[] classes = Arrays.copyOf(classesObj, classesObj.length, String[].class);

                newWeakClassifier.setClassNames(classes);

                newWeakClassifier.setRightBranch(getPdfFromBranch(rightBranch, classes));
                newWeakClassifier.setLeftBranch(getPdfFromBranch(leftBranch,classes));

                weakClassifiers[i] = newWeakClassifier;
                i++;

            }

            // Debug
            // Log.d("ReadClassifiersFromFile", "" + weakClassifiers[0].toString());

            returnable = weakClassifiers;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnable;

    }


    // Extract pdf from a branch, given the keys (classes) in the branch
    private static double[] getPdfFromBranch(JSONObject branch, String[] classes) {
        double[] pdf = new double[classes.length];
        for (int i = 0; i < classes.length; i++) {
            pdf[i] = ((Number) branch.get(classes[i])).doubleValue();
        }
        return pdf;
    }
}
