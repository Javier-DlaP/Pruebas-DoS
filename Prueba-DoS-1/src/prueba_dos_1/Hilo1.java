package prueba_dos_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Hilo1 extends Thread {

    private InetAddress servidor;
    private Socket cliente;
    private DataOutputStream salida;

    public Hilo1(InetAddress servidor) {
        this.servidor = servidor;
    }
    
    public void run(){
        try {
            cliente = new Socket(servidor, 443);
            cliente.setKeepAlive(true);
            System.out.println("Conectado al servidor");
            salida = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Creada salida de datos");
            for(int i=0; i<10; i++){
                salida.writeUTF("Hola");
                System.out.println("Mensaje escrito");
                salida.flush();
            }
        } catch (Exception ex) {
            try {
                cliente.close();
            } catch (IOException ex1) {
                System.out.println("Error al cerrar la conexión");
            }
            System.out.println(ex.getMessage());
            System.out.println("Cerrando conexión");
        }
    }
}
