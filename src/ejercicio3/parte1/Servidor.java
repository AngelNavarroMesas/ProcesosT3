package ejercicio3.parte1;


import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            Random numerosAleatorios = new Random();
            int numeroAleatorio = numerosAleatorios.nextInt(100);
            System.out.println("(Servidor) Creando socket...");
            socket = new DatagramSocket(100);

            while (true) {
                byte[] buffer = new byte[64];

                DatagramPacket datagramaEntrada = new DatagramPacket(buffer, buffer.length);

                System.out.println("(Servidor) Esperando peticiones...");
                socket.receive(datagramaEntrada);

                new GestorProcesos(numeroAleatorio, socket, datagramaEntrada).start();
            }
        } catch (SocketException e) {
            System.out.println("Error al crear el Socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al recibir el paquete");
            e.printStackTrace();
        }

    }
}
