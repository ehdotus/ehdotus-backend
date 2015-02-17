package ehdotus.estimators;

/**
 * Created by shemmink on 15.2.2015.
 */
public class Features {


    public static double getFeatureValueByName(String featureName) {

        FeatureNames feature = FeatureNames.valueOf(featureName.toUpperCase());

        switch (feature) {

        case GENDER:
        	
        	break;

        case YOB:
        	
        	break;

        case HAS_EXPR:
        	
        	break;

        case WORK_RATIO:
        	
        	break;

        case SUBMIT_RATIO:
        	
        	break;

        case SECONDS_SPENT:
        	
        	break;

        case PERCENTAGE_COMPILES:
        	
        	break;

        case NUM_OF_STATES:
        	
        	break;

        case SECONDS_IN_COMPILE:
        	
        	break;

        case SECONDS_IN_NONCOMPILE:
        	
        	break;

        case LINES_OF_CODE:
        	
        	break;

        case FLOW_CONTROL_ELEMENTS:
        	
        	break;
        }


        return 0;

    }


    public enum FeatureNames {
        // NAME				   // ID
    	GENDER,                // 1
        YOB,                   // 2
        HAS_EXPR,              // 3
        WORK_RATIO,            // 4
        SUBMIT_RATIO,          // 5
        SECONDS_SPENT,         // 6
        PERCENTAGE_COMPILES,   // 7
        NUM_OF_STATES,         // 8
        SECONDS_IN_COMPILE,    // 9
        SECONDS_IN_NONCOMPILE, // 10
        LINES_OF_CODE,         // 11
        FLOW_CONTROL_ELEMENTS  // 12
    }


    }


