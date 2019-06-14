package com.company;

class Water
{
    String one="H2";
    String two="O";

    String createWater()
    {
        return (one+two);
    }
}

class Color extends Water
{
    private String color;

    Color(String color)
    {
        this.color=color;
    }

    String createColor()
    {
        return (super.createWater()+"+"+color+"="+color);
    }
}

public class InheritanceDemo
{
    public static void main(String[] args)
    {
        Color c=new Color("White");
        System.out.println(c.createColor());
    }
}
