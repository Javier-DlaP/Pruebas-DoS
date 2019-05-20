package prueba.dos.pkg1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {

    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public Hilo(Socket cliente) {
        this.cliente = cliente;
    }
    
    public void run(){
        try {
            salida  = new DataOutputStream(cliente.getOutputStream());
            entrada  = new DataInputStream(cliente.getInputStream());
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
