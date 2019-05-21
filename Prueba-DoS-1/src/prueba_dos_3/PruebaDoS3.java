package prueba_dos_3;

import prueba_dos_1.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaDoS3 {

    public static void main(String[] args) throws IOException {
        InetAddress servidor;
        ExecutorService pool = Executors.newFixedThreadPool(8);
        try {
            servidor = InetAddress.getByName("95.60.240.202");
            System.out.println("Obtenida ip del servidor");
            System.out.println(servidor);
            //while(true){
            for(int i=0; i<8; i++){
                pool.execute(new Hilo3(servidor));
            }
        } catch (IOException e) {
            System.out.println("Error al conectarse con el servidor");
            pool.shutdown();
            System.exit(0);
        }
    }
}
