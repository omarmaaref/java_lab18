package ex3;
import ex3.Event;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

public class CleanerTask extends Thread {
    public static volatile Deque<Event> deque;
    public static volatile AtomicBoolean atomicBoolean;
    public CleanerTask(Deque<Event> a, AtomicBoolean atomicBoolean){
        deque=a;
        this.atomicBoolean=atomicBoolean;
    }
    public void run() {
        while (true) {
            if (deque.size()!=0){
            atomicBoolean.compareAndSet(true, false);
            Date date = new Date();
            clean(date);
            atomicBoolean.compareAndSet(false, true);

        }}
        }
    private void  clean(Date date) {
        synchronized(this){
        if (date.getTime()-deque.peekFirst().getDate().getTime()>=1000) {
      //if (true) {
        System.out.println(deque.peekFirst().getDate()+"  Dead  "+(date.getTime()-deque.peekFirst().getDate().getTime()));
        deque.pop();
    }}
        }
        }

