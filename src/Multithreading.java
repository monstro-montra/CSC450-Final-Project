public class Multithreading implements Runnable{
    private final int amt;
    private final char whichWay;
    private final int speed;

    public Multithreading(int amt, char whichWay, int speed){
        this.amt = amt;
        this.whichWay = whichWay;
        this.speed = speed;
    }

    @Override
    public void run(){
        count(amt, whichWay, speed);
    }

    public void count(int amt, char whichWay, int speed) {
        switch (whichWay) {
            case 'f' -> { //case for incrementing up
                for (int i = 0; i <= amt; i++) { // loop as long as i <= amt, incrementing i by 1 each time
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException er) {
                        System.out.println("Error, please try again.");
                    }
                }
            }

            case 'r' -> { //case for decrementing down from amt
                for (int i = amt; i >= 0; i--) { //loop as long as i >= 0, decrementing i by 1 each time
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException er) {
                        System.out.println("Error, please try again.");
                    }
                }
            }
        }

    }

}
