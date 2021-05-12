package ex3;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WriterTask implements Runnable {
    public static volatile Deque<Event> deque;
    public static volatile AtomicBoolean atomicBoolean;

    public WriterTask(Deque<Event> a, AtomicBoolean atomicBoolean){
        deque=a;
        this.atomicBoolean=atomicBoolean;
    }
    public void  run() {
        for(int i=0;i<100;i++) {
            synchronized(this){

            Event e = new Event();
            e.setDate(new Date());
            atomicBoolean.compareAndSet(true, false);
            deque.addLast(e);
                atomicBoolean.compareAndSet(false, true);
            System.out.println(e.getDate() + "  start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
    }
}