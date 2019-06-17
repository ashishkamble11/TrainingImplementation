package com.company;

public class CurcularDoublyList
{
    public static void main(String[] args)
    {
        CircularD list=new CircularD();

        System.out.println("Creating list:");
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.printList(list);

        System.out.println("Adding at start:");
        list.insertStart(6);
        list.printList(list);

        System.out.println("Adding at end:");
        list.insertEnd(7);
        list.printList(list);

        System.out.println("After a key:");
        list.insertAfter(5,8);
        list.printList(list);

        System.out.println("Delete by key:");
        list.delete(6);
        list.printList(list);

        System.out.println("Adding at start:");
        list.insertStart(10);
        list.printList(list);

        System.out.println("Delete by key:");
        list.delete(10);
        list.printList(list);

        System.out.println("Delete by key:");
        list.delete(7);
        list.printList(list);

        System.out.println("Delete by key:");
        list.delete(8);
        list.printList(list);
    }
}

class CircularD
{
    Node head;

    static class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data=data;
            next=prev=null;
        }
    }

    void printList(CircularD list)
    {
        Node currnode=head;

        do
        {
            System.out.println(currnode.data);
            currnode=currnode.next;
        }while(currnode!=head);
    }

    void insert(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            newnode.next=newnode.prev=newnode;
            head=newnode;
        }
        Node currnode=head.prev;
        newnode.next=head;
        head.prev=newnode;
        newnode.prev=currnode;
        currnode.next=newnode;
    }

    void insertStart(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            insert(data);
        }
        else
        {
            newnode.prev=head.prev;
            head.prev.next=newnode;
            head.prev=newnode;
            newnode.next=head;
            head=newnode;
        }
    }

    void insertEnd(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            insert(data);
        }
        else
        {
            newnode.next=head.prev.next;
            newnode.prev=head.prev.prev;
            head.prev.next=newnode;
            head.prev=newnode;
        }

    }

    void insertAfter(int olddata, int data)
    {
        Node newnode=new Node(data);
        Node currnode=head;

        do
        {
            currnode=currnode.next;
        }while(currnode.data!=olddata);

        newnode.next=currnode.next;
        currnode.next.prev=newnode;
        newnode.prev=currnode;
        currnode.next=newnode;
    }

    void delete(int data)
    {
        Node currnode=head,previous,temp;

        if(currnode.data==data)
        {
            head=currnode.next;
            currnode.next.prev=currnode.prev;
            currnode.prev.next=currnode.next;
            return;
        }

        do
        {
            previous=currnode;
            currnode=currnode.next;
        }while(currnode.data!=data);
        temp=currnode.next;

        previous.next=currnode.next;
        temp.prev=currnode.prev;
    }
}
