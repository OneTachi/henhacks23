package ow.henhacks23;

import java.util.Hashtable;

public class Node {

    public String name;
    public boolean visited;
    public int distance;
    public Hashtable connections;

    public Node(String newName, Hashtable connections) {
        this.name = newName;
        this.connections = connections;
    }
    public String getName() {
        return name;
    }
    public boolean getVisited() {
        return visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setVisited(boolean hasVisited) {
        this.visited = hasVisited;
    }

    public void setDistance(int newDistance) {
        this.distance = newDistance;
    }
}
