package ow.henhacks23;

/**
 * Connection.java
 * 4/30/2023
 * OWL
 *
 * Creates a connection between a node and another node with a set distance
 */
public class Connection
{
    //A Node that this node is connected to
    Node node;

    //A set distance between both nodes
    int distance;

    //A constructor that creates a connection with a set distance
    // @param
    // - Node: a node this node is connected with
    // - Distance: the distance between the nodes
    //
    // @return
    // Returns a connection
    public Connection(Node node, int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}
