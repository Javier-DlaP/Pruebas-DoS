package prueba_dos_2;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaDoS2 {

    public static void main(String[] args) throws IOException {
        InetAddress servidor;
        ExecutorService pool = Executors.newFixedThreadPool(200);
        try {
            servidor = InetAddress.getByName("216.58.201.163");
            System.out.println("Obtenida ip del servidor");
            System.out.println(servidor);
            while(true){
                pool.execute(new Hilo2(servidor));
            }
        } catch (IOException e) {
            System.out.println("Error al conectarse con el servidor");
            pool.shutdown();
            System.exit(0);
        }
    }
}
