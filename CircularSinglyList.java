package com.company;

public class CircularSinglyList
{
    public static void main(String[] args)
    {
        Circular list=new Circular();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.printList(list);

        list.insertBeginig(6);
        list.insertBeginig(7);
        list.printList(list);

        list.insertAfter(5,8);
        list.printList(list);

        list.delete(7);
        list.printList(list);
    }
}

class Circular
{
    Node head=null;
    Node tail=null;

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            next=null;
        }
    }

    void printList(Circular list)
    {
        Node currnode=list.head;
        System.out.println("Linkedlist: ");
        do
        {
            System.out.println(currnode.data);
            currnode=currnode.next;
        }while (currnode!=head);
        System.out.println();
    }

    void append(int data)
    {
        Node currnode=head;
        if(currnode==null)
        {
            insertBeginig(data);
        }
        else
        {
            Node newnode=new Node(data);
            tail.next=newnode;
            tail=newnode;
            tail.next=head;
        }
    }

    void insertBeginig(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
            newnode.next=head;
        }
        else
        {
            Node currnode=head;
            newnode.next=currnode;
            head=newnode;
            tail.next=head;
        }
    }

    void insertAfter(int olddata, int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            insertBeginig(data);
        }
        else
        {
            Node currnode=head;

            do
            {
                currnode=currnode.next;
            }while(currnode.data!=olddata);

            newnode.next=currnode.next;
            currnode.next=newnode;
        }
    }

    void delete(int data)
    {
        Node currnode=head;
        Node previous;

        if(currnode.data==data)
        {
            head=currnode.next;
            tail.next=head;
            return;
        }

        do
        {
            previous=currnode;
            currnode=currnode.next;
        }while(currnode.data!=data);

        previous.next=currnode.next;
    }
}
