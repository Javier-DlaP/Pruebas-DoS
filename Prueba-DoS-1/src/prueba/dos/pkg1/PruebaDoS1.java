package prueba.dos.pkg1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class PruebaDoS1 {

    public static void main(String[] args) throws IOException {
        Socket cliente;
        InetAddress servidor;
        try {
            servidor = InetAddress.getByName("www.asesoriafislaso.es");
            //servidor = InetAddress.getByName("185.199.109.153");
            System.out.println("Obtenida ip del servidor");
            System.out.println(servidor);
            //cliente = new Socket(servidor, 443);
            //System.out.println("Conectado al servidor");
            while(true){
                new Hilo(new Socket(servidor, 443)).start();
            }
            //cliente.close();
        } catch (IOException e) {
            System.out.println("Error al conectarse con el servidor");
            //cliente.close();
            System.exit(0);
        }
    }
}
