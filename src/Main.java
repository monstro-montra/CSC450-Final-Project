import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Multithreading forwardCount = new Multithreading(20, 'f', 250);
        Multithreading reverseCount = new Multithreading (20, 'r', 250);
        Thread thread1 = new Thread(forwardCount);
        Thread thread2 = new Thread(reverseCount);

        System.out.print("Thread 1: ");
        thread1.start();
        try{
            in.nextLine();
            thread1.join();
        } catch (InterruptedException ignored){
        }

        System.out.print("\nThread 2: ");
        thread2.start();
        try{
            in.nextLine();
            thread2.join();
        } catch (InterruptedException ignored){
        }

    }
}
