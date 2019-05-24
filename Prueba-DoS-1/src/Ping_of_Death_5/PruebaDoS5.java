package Ping_of_Death_5;

import java.io.IOException;

public class PruebaDoS5 {
    public static void main(String[] args) throws IOException {
        for(int i=0; i<32; i++){
            new Hilo5().start();
        }
        
    }
}
