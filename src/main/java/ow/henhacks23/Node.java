package ow.henhacks23;

// Node.java
// 4/30/2023
// OWL
//
// Node Class - A class that contains the location of each hall or nearby locations like the center area
// inside kirkbride, smith, purnell, and ewing.
//
public class Node
{
    //Not Used
    int x;

    //Not Used
    int y;

    // The previous node
    public Node prev = null;

    // The name of the node
    public String name;

    // A byte indicated if the node has been visited
    public byte visited = 0;

    // The distance value for each node to calculate the minimum distance to one location to another
    public int value = 1000; // == Value

    // The connections a single node has
    public Connection connections[];

    // A constructor that takes in a connection
    public Node(Connection[] connections)
    {
        this.connections = connections;
    }

    // A constructor that takes no parameters and sets their connections to null - mainly used for testing
    public Node()
    {
        connections = null;
    }

    // A constructor that takes in a connection and a name
    public Node(Connection[] connections, String name)
    {
        this.connections = connections;
        this.name = name;
    }

    // A function that gets the nodes connection with the minimum value
    //
    // No Parameters
    // Returns a Node
    public Node lookAtConnections()
    {
        Node min = null;
        if (connections != null)
            for (Connection con : connections)
            {
                if (con.node.visited == 0)
                {
                    if (con.node.value > value + con.distance)
                    {
                        con.node.value = value + con.distance;
                        con.node.prev = this;
                    }
                    if (min == null || min.value > con.node.value)
                    {
                        min = con.node;
                    }
                }
            }
        return min;
    }

    // A Override of the toString function that makes the node return its value
    @Override
    public String toString()
    {
        return value + " ";
    }
}
