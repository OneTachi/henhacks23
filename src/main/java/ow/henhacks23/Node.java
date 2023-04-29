package ow.henhacks23;

public class Node
{

    public Node prev = null;

    public byte visited = 0;
    public int value = 1000; // == Value
    public Connection connections[];


    public Node(Connection[] connections)
    {
        this.connections = connections;
    }

    public Node()
    {
        connections = null;
    }

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

    @Override
    public String toString()
    {
        return value + " ";
    }
}
