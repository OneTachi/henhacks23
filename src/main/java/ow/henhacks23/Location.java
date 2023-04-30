package ow.henhacks23;

public class Location
{
    private String name;
    private Node node;
    private int xPosition;
    private int yPosition;
    public int getXPosition() { return xPosition; }
    public int getYPosition() { return yPosition; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void setXPosition(int position) { this.xPosition = position; }
    public void setYPosition(int position) { this.yPosition = position; }

    public Node getNode() {return this.node;}

    public Location (String name, int xPosition, int yPosition)
    {
        setName(name);

        this.node = new Node(new Connection[] {});
        getNode().x = xPosition;
        getNode().y = yPosition;
    }

    public Location (String name)
    {
        setName(name);
    }
}
