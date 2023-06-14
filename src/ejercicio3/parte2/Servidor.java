package ejercicio3.parte2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(100);
            InputStream is;
            BufferedReader br;
            InputStreamReader ir;
            String mensajeRecibido;
            Socket peticion;

            while (true) {
                peticion = servidor.accept();

                is = peticion.getInputStream();

                ir = new InputStreamReader(is);
                br = new BufferedReader(ir);

                mensajeRecibido = br.readLine();
                new GestorProcesos(mensajeRecibido, peticion).start();
            }

        } catch (IOException e) {
            System.err.println("Ha habido algún error en la creación del Socket Servidor");
            e.printStackTrace();
        }
    }
}
