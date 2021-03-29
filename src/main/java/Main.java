import block.BlockingQueueClass;
import component.*;
import dashboard.*;
import validator.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String... args) {


        BlockingQueueClass queue = new BlockingQueueClass(5);


        queue.add(new Object());
        queue.add(new Object());


        Runnable task1 = new Runnable() {
            @Override
            public void run() {

                try {

                    for(int i=0;i<6;i++) {
                        queue.put(new Object());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread1 = new Thread(task1);

        thread1.start();



        Runnable task2 = new Runnable() {
            @Override
            public void run() {

                try {

                    queue.take();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        Thread thread2 = new Thread(task2);

        thread2.start();

        queue.add(new Object());






    }
}
