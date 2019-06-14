package com.company;

public class LinkListDemo
{
    public static void main(String[] args)
    {
        List list=new List();

        list.insert(list,1);
        list.insert(list,2);
        list.insert(list,3);
        list.insert(list,4);
        list.insert(list,5);

        list.printList(list);

        list.removeByKey(list,2);
        list.removeByKey(list,6);

        list.insertBegin(list,6);

        list.printList(list);

        list.insertAfter(4,7);

        list.printList(list);
    }
}

class List
{
    Node head;

    static class Node
    {
        int key;
        Node next;
        Node(int d)
        {
            key=d;
            next=null;
        }
    }

    void printList(List list)
    {
        Node currnode=list.head;
        System.out.println("Linkedlist: ");
        while (currnode!=null)
        {
            System.out.println(currnode.key+" ");
            currnode=currnode.next;
        }
        System.out.println();
    }

    List insert(List list, int data)
    {
        Node new_node=new Node(data);
        new_node.next=null;

        if(list.head==null)
        {
            list.head=new_node;
        }
        else
        {
            Node last=list.head;
            while(last.next!=null)
            {
                last=last.next;
            }
            last.next=new_node;
        }

        return list;
    }

    List insertBegin(List list, int data)
    {
        Node newnode=new Node(data);
        newnode.next=null;

        if(list.head==null)
        {
            list.head=newnode;
        }
        else
        {
            newnode.next=head;
            head=newnode;
        }
        return list;
    }

    void insertAfter(int olddata, int newdata)
    {
        Node newnode=new Node(newdata);

        Node currnode=head;

        while(currnode!=null)
        {
            if(currnode.key==newdata)
            {
                newnode.next=currnode.next;
                currnode.next=newnode;
            }
        }
    }

    List removeByKey(List list, int data)
    {
        Node currnode=list.head, prev=null;

        if(currnode != null && currnode.key==data)
        {
            list.head=currnode.next;
            System.out.println("Deleted "+data);
            return list;
        }

        while (currnode!=null && currnode.key!=data)
        {
            prev=currnode;
            currnode=currnode.next;
        }

        if(currnode!=null)
        {
            prev.next=currnode.next;
            System.out.println("Deleted "+data);
        }

        if(currnode==null)
        {
            System.out.println("Data not found.");
        }
        return list;
    }
}