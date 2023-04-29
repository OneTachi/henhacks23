package ow.henhacks23;

public class Node {

    public String name;

    public boolean visited;
    public int distance = 100; // == Value



    public Node(String newName, int newDistance) {
        this.name = newName;
        this.distance = newDistance;
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
