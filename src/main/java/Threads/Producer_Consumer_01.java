package Threads;

/**
 * we have 2 producer adn two consumer
 * and ArrayBlockingQueue so it is very simple
 * Also i have implemented custome Custome BlockingQueue and used
 */
public class Producer_Consumer_01 {

    static int input = 0;

    public static void main(String[] a) {

        // create a Blocking Q

        // java Queue
        // ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        // implement my Custom Quue
        MyArrayBlockingQueue<Integer> arrayBlockingQueue = new MyArrayBlockingQueue<>(10);


        // producer code
        Runnable target;
        Thread p1 = new Thread(() ->
        {
            while (true) {
                try {
                    arrayBlockingQueue.put(input++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread p2 = new Thread(() ->
        {
            while (true) {
                try {
                    arrayBlockingQueue.put(input++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        p1.start();
        p2.start();


        // consumer

        Thread c1 = new Thread(() ->
        {
            while (true) {
                try {
                    int i = arrayBlockingQueue.take();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c2 = new Thread(() ->
        {
            while (true) {
                try {
                    int i = arrayBlockingQueue.take();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        c1.start();
        c2.start();

    }
}
