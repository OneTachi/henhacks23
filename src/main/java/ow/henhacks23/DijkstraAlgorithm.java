package ow.henhacks23;

import java.util.ArrayList;

public class DijkstraAlgorithm {
    public boolean[] visitedNodes;
    public int start;
    public int destination;
    public int[] prev;
    public Location[] locations;
    public int[] distances;
    public int[][] distanceMatrix;
    public int numOfLocations;

    public DijkstraAlgorithm(int[][] distanceMatrix, int numOfLocations, Location[] locations) {
        this.distanceMatrix = distanceMatrix;
        this.numOfLocations = numOfLocations;
        this.distances = new int[numOfLocations];
        this.prev = new int[numOfLocations];
        this.visitedNodes = new boolean[numOfLocations];
        this.locations = locations;
        for (int i = 0; i < numOfLocations; i++) {
            distanceMatrix[i] = new int[numOfLocations];
            distances[i] = 100000;
            visitedNodes[i] = false;
            prev[i] = 0;
        }
    }
    public void runDijkstra() {
        distances[start] = 0;
        visitedNodes[start] = true;
        for (int i = 0; i < numOfLocations; i++) {
            distances[i] = distanceMatrix[start][i];
            prev[i] = start;
        }
        prev[start] = -1;
        for (int k = 0; k < numOfLocations - 1; k++) {
            int m = minDistance();
            visitedNodes[m] = true;
            setDistances(m);
        }
    }

    public void setDistances(int latestVert) {
        for(int i = 0; i < numOfLocations; i++){
            if (visitedNodes[i] == false &&distances[latestVert] != 10000 && distances[latestVert]+distanceMatrix[latestVert][i]<distances[i] ){
                distances[i] = distances[latestVert] + distanceMatrix[latestVert][i];
                prev[i] = latestVert;
            }
        }
    }

    public int minDistance() {
        int min = 100000;
        int min_index = 0;
        for(int i = 0; i < numOfLocations; i++){
            if(visitedNodes[i] == false && distances[i] <= min){
                min = distances[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public String runMapping() {
        String pathInString = "";
        int[] path = new int[numOfLocations];
        int ct = 0;
        path[ct] = destination;
        int dist = distances[destination];
        int prevnode = prev[destination];
        ct++;
        while (prevnode != start) {
            path[ct] = prevnode;
            prevnode = prev[prevnode];
            ct++;
        }
        path[ct] = start;
        pathInString += "Shortest Path: " + dist + "\n";
        for (int i = ct; i >= 0; i--) {
            pathInString += locations[path[i]] + "(" + path[i] + ")\n";
        }
        return pathInString;
    }
}
