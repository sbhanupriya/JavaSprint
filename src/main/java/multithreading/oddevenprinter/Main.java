package multithreading.oddevenprinter;

public class Main {
    public static void main(String[] args){
        SharedClass sharedClass = new SharedClass(10);
//        Thread oddPrinter = new Thread(new OddPrinter(sharedClass),"oddPrinter");
//        Thread evenPrinter = new Thread(new EvenPrinter(sharedClass),"evenPrinter");
//        oddPrinter.start();
//        evenPrinter.start();

        Thread thread1 = new Thread(new SingleOddEvenPrinter(sharedClass,true),"even thread");
        Thread thread2 = new Thread(new SingleOddEvenPrinter(sharedClass,false),"odd thread");
        thread1.start();
        thread2.start();

    }
}
