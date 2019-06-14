package com.company;

abstract class Car
{
    void move()
    {
        System.out.println("Move forward/reverse.");
    }
    void stop()
    {
        System.out.println("Apply brakes.");
    }
    abstract void calculateMileage();
    abstract void changeSpeed();
}

class MahindraCar extends Car
{
    void calculateMileage()
    {
        System.out.println("Calculating Mileage.");
    }
    void changeSpeed()
    {
        System.out.println("Increase Speed/Decrease Speed");
    }
    void interiorOfCar()
    {
        System.out.println("Use Leather.");
    }
}

public class AbstractionDemo {
    public static void main(String[] args)
    {
        Car car1=new MahindraCar();
        car1.move();
        car1.changeSpeed();
        car1.calculateMileage();
        car1.stop();
    }
}
