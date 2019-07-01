public class InheritanceDemo
{
    public static void main(String[] args)
    {
        ColorPrinter cp=new ColorPrinter();
        cp.colorPrint();
        BlackAndWhitePrinter bwp=new BlackAndWhitePrinter();
        bwp.blackAndWhitePrint();
        Printer p=new Printer();
        p.print();
    }
}

class Printer
{
    void print()
    {
        System.out.print("Printing ");
    }
}

class ColorPrinter extends Printer
{
    void colorPrint()
    {
        super.print();
        System.out.println("Color Job.");
    }
}

class BlackAndWhitePrinter extends Printer
{
    void blackAndWhitePrint()
    {
        super.print();
        System.out.println("Black and White Job.");
    }
}