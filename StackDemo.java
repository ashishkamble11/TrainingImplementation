package com.company;

import java.util.Stack;

public class StackDemo
{
    int top;
    int arr[];

    StackDemo(int size)
    {
        top=-1;
        arr=new int[size];
    }

    public static void main(String[] args)
    {
        StackDemo stack=new StackDemo(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    void push(int value)
    {
        if(isFull()==true)
            System.out.println("Stack is full.");
        else
            arr[++top]=value;
    }

    void pop()
    {
        if(isEmpty()==true)
            System.out.println("Stack is empty.");
        else
        {
            System.out.println(arr[top--]+" Removed");
        }
    }

    int returnTopElement()
    {
        int temp=0;
        if(!isEmpty())
        {
            temp=arr[top];
        }
        return temp;
    }

    boolean isEmpty()
    {
        boolean temp=false;
        if(top==-1)
        {
            temp=true;
        }
        return temp;
    }

    boolean isFull()
    {
        boolean temp=false;
        if(top==arr.length-1)
        {
            temp=true;
        }
        return temp;
    }
}