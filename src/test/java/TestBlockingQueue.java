import org.junit.jupiter.api.*;
import queue.BlockingQueueClass;

public class TestBlockingQueue {

    private BlockingQueueClass<String> queue;

    Runnable addString = new Runnable() {
        @Override
        public void run() {
            queue.add("string1");
        }
    };

    Runnable offerString = new Runnable() {
        @Override
        public void run() {
            queue.offer("some string");
        }
    };

    Runnable putString = new Runnable() {
        @Override
        public void run() {
            queue.put("str");
        }
    };

    Runnable takeString = new Runnable() {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    @Test
    public void queueShouldThrowExceptionBecauseQueueIsFull() {
        queue = new BlockingQueueClass<>(2);
        Thread thread1 = new Thread(addString);
        Thread thread2 = new Thread(addString);
        Thread thread3 = new Thread(addString);
        Assertions.assertThrows(IllegalStateException.class, ()->{
            thread1.start();
            thread2.start();
            thread3.start();
        });
    }
}
