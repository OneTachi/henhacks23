package ow.henhacks23;

public class Location
{
    private String name;
    private Object position;
    public Object getPosition() { return position; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void setPosition(Object position) { this.position = position; }

    public Location (String name, Object position)
    {
        setName(name);
        setPosition(position);
    }

    public Location (String name)
    {
        setName(name);
    }
}
