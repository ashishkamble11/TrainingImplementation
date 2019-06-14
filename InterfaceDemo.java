package com.company;

interface RBIBank
{
    void creditBalance(int x);
    void debitBalance(int x);
}

class HDFCBank implements RBIBank
{
    private int x;

    HDFCBank(int x)
    {
        this.x=x;
    }

    @Override
    public void creditBalance(int x) {
        this.x+=x;
    }

    @Override
    public void debitBalance(int x) {
        this.x-=x;
    }

    void printBalance()
    {
        System.out.println("Balance: "+x);
    }
}

public class InterfaceDemo {
    public static void main(String[] args)
    {
        HDFCBank b=new HDFCBank(20);
        b.printBalance();
        b.creditBalance(15);
        b.printBalance();
        b.debitBalance(10);
        b.printBalance();
    }
}
