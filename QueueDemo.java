package com.company;

public class QueueDemo
{
    int arr[];
    int front;
    int rear;

    QueueDemo(int size)
    {
        arr=new int[size];
        front=rear=-1;
    }

    public static void main(String[] args)
    {
        QueueDemo queue=new QueueDemo(4);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

    void enqueue(int value)
    {
        if(isFull()==true)
        {
            System.out.println("Queue is Full.");
            return;
        }
        else
        {
            if(front==-1)
                front=0;
            arr[++rear]=value;
        }
    }

    void dequeue()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println(arr[front++]+" Removed.");
    }

    boolean isEmpty()
    {
        boolean temp=false;
        if(front==-1 || front > rear)
            temp=true;
        return temp;
    }

    boolean isFull()
    {
        boolean temp=false;
        if(rear==arr.length-1)
            temp=true;
        return temp;
    }
}