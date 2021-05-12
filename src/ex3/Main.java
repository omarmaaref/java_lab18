package ex3;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;



public class Main {
        public static void main(String[] args) throws InterruptedException {
            Deque<Event> q=new LinkedList<Event>();
             AtomicBoolean atomicBoolean = new AtomicBoolean(false);

Thread t1=new Thread(new WriterTask(q,atomicBoolean));
Thread t2=new Thread(new WriterTask(q,atomicBoolean));
            Thread t3=new Thread(new WriterTask(q,atomicBoolean));
            Thread t4=new Thread(new WriterTask(q,atomicBoolean));
Thread cleaner=new Thread(new CleanerTask(q,atomicBoolean));

t1.start();
t2.start();
            t3.start();
            t4.start();
            cleaner.start();
        }
}
