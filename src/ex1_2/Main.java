package ex1_2;
import ex1_2.exemple1;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;


public class Main {
    public static void main(String[] args){
/*
		// Thread priority infomation
				System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
				System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
				System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

				Thread threads[];
				State status[];

				// Launch 10 threads to do the operation, 5 with the max
				// priority, 5 with the min
				threads = new Thread[10];
				status = new State[10];
				for (int i = 0; i < 10; i++) {
					threads[i] = new Thread(new Calculator());
					if ((i % 2) == 0) {
						threads[i].setPriority(Thread.MAX_PRIORITY);
					} else {
						threads[i].setPriority(Thread.MIN_PRIORITY);
					}
					threads[i].setName("My Thread " + i);
				}
				try (FileWriter file = new FileWriter("log.txt"); PrintWriter pw = new PrintWriter(file);) {

					// Write the status of the threads
					for (int i = 0; i < 10; i++) {
						pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
						status[i] = threads[i].getState();
					}

					// Start the ten threads
					for (int i = 0; i < 10; i++) {
						threads[i].start();
					}
					// Wait for the finalization of the threads. We save the status of
					// the threads and only write the status if it changes.
					boolean finish = false;
					while (!finish) {
						for (int i = 0; i < 10; i++) {
							if (threads[i].getState() != status[i]) {
								writeThreadInfo(pw, threads[i], status[i]);
								status[i] = threads[i].getState();
							}
						}

						finish = true;
						for (int i = 0; i < 10; i++) {
							finish = finish && (threads[i].getState() == State.TERMINATED);
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}*/
        try{
            FileWriter fw = new FileWriter("logEX2_join.txt", true);
            PrintWriter pw = new PrintWriter(fw);


            exemple1.writer=pw;
            exemple1 thread1, thread2, thread3;
            thread1=new exemple1("Bonjour ");
            thread2=new exemple1("Bonsoir ");
            thread3=new exemple1("à demain ");
            System.out.println("Je suis le main :)");
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
            System.out.println("main terminé");
//			System.exit(0);
        }
        catch(IOException | InterruptedException e){}
    }

}
