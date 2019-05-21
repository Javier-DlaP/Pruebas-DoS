package Ping_of_Death_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hilo5 extends Thread{
    ProcessBuilder builder;

    public Hilo5(ProcessBuilder builder) {
        this.builder = builder;
    }
    
    @Override
    public void run(){
        Process p;
        BufferedReader r;
        try {
            p = builder.start();
            r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
