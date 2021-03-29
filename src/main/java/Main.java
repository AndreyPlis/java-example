import component.*;

public class Main {

    public static void main(String... args) throws InterruptedException {

        Incrementor incrementor = new Incrementor();

        Runnable task = () -> incrementor.increment();

        Runnable task2 = () -> incrementor.decrement();

        Thread thread = new Thread(task,"myThread");

        thread.start();

        Thread thread2 = new Thread(task2,"myThread2");

        thread2.start();


        thread.join();
        thread2.join();
    }
}
