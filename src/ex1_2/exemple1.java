package ex1_2;

import java.io.PrintWriter;

public class exemple1 extends Thread {
    private String Salutation;
    private int attente;
    private int number;
    public exemple1(String Salutation) {
        this.Salutation=Salutation;
    }
    public void run() {
        for (int i =1; i< 1000; i++){
            writer.printf(i + " " + Salutation +System.lineSeparator());
            System.out.println(i + " " + Salutation );
        }

    }
    public static PrintWriter writer ;
}
