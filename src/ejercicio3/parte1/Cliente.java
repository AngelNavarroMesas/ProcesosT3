package ejercicio3.parte1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        DatagramSocket socket = null;
        int puertoServidor = 100;
        String nombreServidor = "localhost";
        Scanner sc = new Scanner(System.in);
        String numero;
        String mensajeRecibido="";
        try {
            System.out.println("(Cliente): Estableciendo parámetros de conexión...");
            InetAddress direccionServidor = InetAddress.getByName(nombreServidor);


            System.out.println("(Cliente): Creando el socket...");
            socket = new DatagramSocket();

            System.out.println("(Cliente): Creando datagrama...");

            while (!mensajeRecibido.contains("Has adivinado el número")){
                System.out.println("Introduzca un número:");
                numero = sc.nextLine().trim();

                byte[] bufferSalida = numero.getBytes();
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionServidor,
                        puertoServidor);

                System.out.println("(Cliente) Enviando datagrama...");
                socket.send(paqueteSalida);

                System.out.println("(Cliente) Recibiendo respuesta...");
                byte[] bufferEntrada = new byte[64];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length, direccionServidor,
                        puertoServidor);
                socket.receive(paqueteEntrada);
                mensajeRecibido = new String(bufferEntrada).trim();
                System.out.println(mensajeRecibido);
            }

            System.out.println("Has acertado");
            socket.close();

            System.out.println("(Cliente): Cerrando conexión...");
            socket.close();
            System.out.println("(Cliente): Conexión cerrada.");

        } catch (SocketException e) {
            System.err.println("Error al conectar con el servidor.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("No se ha podido enviar o recibir el paquete");
            e.printStackTrace();
        }

    }
}
