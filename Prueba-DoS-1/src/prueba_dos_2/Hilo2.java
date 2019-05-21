package prueba_dos_2;

import java.io.IOException;
import java.net.InetAddress;

public class Hilo2 extends Thread {

    private InetAddress servidor;

    public Hilo2(InetAddress servidor) {
        this.servidor = servidor;
    }
    
    public void run(){
        try {
            while (true) {
                if (servidor.isReachable(10000)) {
                    System.out.println("Reachable");
                } else {
                    System.out.println("Not reachable");
                }
            }
        } catch (IOException ex) {
            System.out.println("Cerrando el hilo");
        }
    }
}
