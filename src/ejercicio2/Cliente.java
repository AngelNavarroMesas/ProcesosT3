package ejercicio2;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            Socket socketCliente = new Socket(direccion, 1500);

            System.out.println("Abriendo flujos de entrada y salida");
            OutputStream os = socketCliente.getOutputStream();
            InputStream is = socketCliente.getInputStream();

            System.out.println("Enviando mensaje al servidor");
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            for(int i=0;i<10000;i++){
                bw.write("Mensaje: "+i);
                bw.newLine();
                bw.flush();
            }
            bw.write("FIN");
            bw.flush();

            osw.close();
            is.close();
            os.close();
            bw.close();
            socketCliente.close();

        }catch (Exception e){

        }
    }
}
