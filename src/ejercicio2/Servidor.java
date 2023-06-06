package ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        ServerSocket socketServidor;

        try {
            socketServidor = new ServerSocket(1500);
            Socket socketCliente = socketServidor.accept();

            InputStream is = socketCliente.getInputStream();
            OutputStream os = socketCliente.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);



        }catch (Exception e){

        }
    }
}
