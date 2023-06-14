package ejercicio2;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Cliente {
    public static void main(String[] args) {
        InetAddress direccion;
        try {
            direccion = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            int num = 0;
            String mensaje;

            while (num<10000){
                mensaje = "Mensaje: " + num;
                byte[] buffer = mensaje.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 100);
                socket.send(packet);
                num++;
            }
            mensaje = "FIN";
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion, 100);
            socket.send(packet);
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}