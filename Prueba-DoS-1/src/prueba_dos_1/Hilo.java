package prueba_dos_1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Hilo extends Thread {

    private InetAddress servidor;
    private Socket cliente;

    public Hilo(InetAddress servidor) {
        this.servidor = servidor;
    }
    
    public void run(){
        try {
            cliente = new Socket(servidor, 443);
            cliente.close();
        } catch (IOException ex) {
            try {
                cliente.close();
            } catch (IOException ex1) {
                System.out.println("Error al cerrar la conexión");
            }
            System.out.println("Cerrando conexión");
        }
    }
}
