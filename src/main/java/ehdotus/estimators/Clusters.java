package ehdotus.estimators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

/**
 * Created by shemmink on 25.2.2015.
 */
public class Clusters {

    private final HashMap<String, Integer> userClusterMap = new HashMap<>();

    @Value("${userClusters.file}")
    private Resource clusterFile; //  = "userClusters.csv";

    public void loadClusters() {

        BufferedReader br = null;
        String line = "";
        String delim = ",";

        try {
            FileReader userClustersFile = new FileReader(clusterFile.getFile());
            br = new BufferedReader(userClustersFile);

            while ((line = br.readLine()) != null) {

                String[] splits = line.split(delim);
                Integer clusterId = Integer.parseInt(splits[1]);

                userClusterMap.put(splits[0], clusterId);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int getCluster(String userID) {

        if (userClusterMap.size() > 0) {
            return userClusterMap.get(userID);
        } else {
            return -1;
        }
    }

}
