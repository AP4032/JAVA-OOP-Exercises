package Theme_Park_Management_System;

public class Visitor
{
    private String name;
    private String kind;

    public Visitor(String name , String kind)
    {
        this.name = name;
        this.kind = kind;
    }

    public String getName()
    {
        return name;
    }

    public String getKind()
    {
        return kind;
    }
}
