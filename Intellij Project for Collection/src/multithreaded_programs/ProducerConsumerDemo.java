package multithreaded_programs;

import java.util.ArrayDeque;
import java.util.Random;

public class ProducerConsumerDemo {
    public static final int SLEEP_MAX_MIL_SEC = 30000;
    public static final int SIZE = 5;
    public static final int PRODUCER_CNT = 100;
    public static final int CONSUMER_CNT = 10;

    public static void sleep() throws Exception
    {
        Random random = new Random();
        Thread.sleep(random.nextInt(SLEEP_MAX_MIL_SEC));
    }

    public static void main(String[] args) {

        MyQ myQ = new MyQ(SIZE);

        for (int i = 0; i < PRODUCER_CNT; i++)
        {
            Producer producer = new Producer(myQ, i);
        }

        for (int i = 0; i < CONSUMER_CNT; i++)
        {
            Consumer consumer = new Consumer(myQ, i);
        }
    }
}

class Consumer implements Runnable
{
    MyQ myQ;
    int id;

    public Consumer(MyQ myQ, int id) {
        this.myQ = myQ;
        this.id = id;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try
        {
            while (true)
            {
                ProducerConsumerDemo.sleep();

                synchronized (myQ)
                {
                    while (myQ.isEmpty())
                    {
                        System.out.println("Consumer " + id + " will wait");
                        myQ.wait();
                    }
                }

                ProducerConsumerDemo.sleep();

                synchronized (myQ)
                {
                    if (myQ.isEmpty())
                    {
                        continue;
                    }

                    int consumed = myQ.pollFirst();
                    System.out.println("Consumer " + id + " just consumed " + consumed);

                    myQ.notifyAll();
                }

                ProducerConsumerDemo.sleep();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

class Producer implements Runnable
{

    private final int id;
    MyQ myQ;

    Producer(MyQ myQ, int id)
    {
        this.myQ = myQ;
        this.id = id;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
                ProducerConsumerDemo.sleep();

                while (myQ.isFull())
                {
                    synchronized (myQ)
                    {
                        System.out.println("Producer " + id + "  will wait");
                        myQ.wait();
                    }
                }

                ProducerConsumerDemo.sleep();

                synchronized (myQ)
                {
                    if (myQ.isFull())
                    {
                        continue;
                    }

                    System.out.println("Producer " + id + " is producing");
                    myQ.add(id);

                    myQ.notifyAll();
                }

                ProducerConsumerDemo.sleep();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

class MyQ extends ArrayDeque<Integer>
{
    int size;

    public MyQ(int size) {
        super();
        this.size = size;
    }

    boolean isFull()
    {
        return super.size() >= size;
    }
}
