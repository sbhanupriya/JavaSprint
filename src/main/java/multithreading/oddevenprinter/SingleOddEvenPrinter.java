package multithreading.oddevenprinter;

public class SingleOddEvenPrinter implements Runnable {
    private SharedClass sharedClass;
    private boolean isEvenPrinter;
    public SingleOddEvenPrinter(SharedClass sharedClass, boolean isEvenPrinter){
        this.sharedClass = sharedClass;
        this.isEvenPrinter = isEvenPrinter;
    }
    public SharedClass getSharedClass() {
        return sharedClass;
    }

    public void setSharedClass(SharedClass sharedClass) {
        this.sharedClass = sharedClass;
    }

    @Override
    public void run() {
        while(true){
            synchronized (sharedClass) {
                if(((isEvenPrinter && sharedClass.getCounter()%2!=0)||(!isEvenPrinter && sharedClass.getCounter()%2==0))  && sharedClass.getCounter()<=sharedClass.getMAX_VALUE()) {
                    try {
                        sharedClass.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(sharedClass.getCounter()>sharedClass.getMAX_VALUE()){
                    sharedClass.notifyAll();
                    break;
                }
                sharedClass.print();
                sharedClass.notifyAll();
            }
        }
    }
}
