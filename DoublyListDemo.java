package com.company;

public class DoublyListDemo
{
    public static void main(String[] args)
    {
        DList list=new DList();

        System.out.println("Appendding:");
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        list.printList(list);

        System.out.println("Adding to begining:");
        list.insertBegining(6);
        list.insertBegining(7);
        list.printList(list);

        System.out.println("Adding after a key:");
        list.insertAfter(2,8);
        list.printList(list);

        System.out.println("Deleting at key:");
        list.delete(5);
        list.printList(list);
    }
}

class DList
{
    Node head;

    class Node
    {
        int data;
        Node next,prev;
        Node(int data)
        {
            this.data=data;
            prev=next=null;
        }
    }

    void printList(DList list)
    {
        Node currnode=list.head;
        System.out.println("Linkedlist: ");
        while (currnode!=null)
        {
            System.out.println(currnode.data+" ");
            currnode=currnode.next;
        }
        System.out.println();
    }

    void insertEnd(int data)
    {
        Node newnode=new Node(data);
        Node currnode=head;
        newnode.next=null;

        if(head==null)
        {
            newnode.prev=null;
            head=newnode;
            return;
        }
        while(currnode.next!=null)
        {
            currnode=currnode.next;
        }
        currnode.next=newnode;
        newnode.prev=currnode;
    }

    void insertBegining(int data)
    {
        Node newnode=new Node(data);
        newnode.next=head;

        if(head==null)
        {
            newnode.prev=null;
            head=newnode;
            return;
        }

        newnode.prev=null;
        head.prev=newnode;
        head=newnode;
    }

    void insertAfter(int olddata, int data)
    {
        Node newnode=new Node(data);
        Node currnode=head;

        while (currnode!=null && currnode.data!=olddata)
        {
            System.out.println("key is: "+currnode.data);
            currnode=currnode.next;
        }

        if(currnode.next==null && currnode.data==olddata)
        {
            newnode.prev=currnode;
            newnode.next=currnode.next;
        }
        else
        {
            newnode.next=currnode.next;
            currnode.next.prev=newnode;
        }
        newnode.prev=currnode;
        currnode.next=newnode;
    }

    void delete(int data)
    {
        Node currnode=head;
        Node previous=null;

        while(currnode!=null && currnode.data!=data)
        {
            previous=currnode;
            currnode=currnode.next;
        }

        if(currnode!=null && previous==null)
        {
            if(currnode.next!=null)
            {
                head=currnode.next;
            }
            /*if(currnode.next==null)
            {
                currnode.prev.next=null;
            }*/
            else
            {
                head=null;
            }
        }
        else if(currnode.next!=null)
        {
            previous.next=currnode.next;
            currnode.next.prev=currnode.prev;
        }
        else if(currnode.next==null)
        {
            currnode.prev.next=null;
        }
    }
}