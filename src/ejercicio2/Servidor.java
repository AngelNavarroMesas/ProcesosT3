package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(100);
            String mensaje = "";

            File fichero = new File("src/ejercicio2/archivo.txt");
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            while (!mensaje.equals("FIN")) {
                byte[] buffer = new byte[64];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("Esperando al datagrama");
                socket.receive(packet);
                mensaje = new String(packet.getData()).trim();
                if (!mensaje.equals("FIN"))
                    bw.write(mensaje.substring(9) + " ");
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (SocketException e) {
            System.err.println("Error al crear el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error al recibir paquete");
            e.printStackTrace();
        }
    }
}