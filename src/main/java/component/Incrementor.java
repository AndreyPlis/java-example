package component;

public class Incrementor {

    private int increment = 0;

    private Object monitor = new Object();


    public synchronized void increment() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                this.increment++;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("inc " + this.increment + " " + Thread.currentThread());
            }
        }
    }

    public void decrement() {
        synchronized (monitor) {
            for (int i = 0; i < 100; i++) {
                this.increment--;

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("dec " + this.increment + " " + Thread.currentThread());
            }
        }
    }
}
