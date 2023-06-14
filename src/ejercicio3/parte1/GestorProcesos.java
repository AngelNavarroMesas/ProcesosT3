package ejercicio3.parte1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class GestorProcesos extends Thread{
    DatagramSocket socket;
    DatagramPacket datagramaEntrada;
    int numeroAleatorio;


    public GestorProcesos(int numeroAleatorio,DatagramSocket socket, DatagramPacket datagramaEntrada) {
        super();
        this.socket = socket;
        this.datagramaEntrada = datagramaEntrada;
        this.numeroAleatorio=numeroAleatorio;
    }

    @Override
    public void run() {
        realizarProceso();
    }

    public void realizarProceso() {
        String mensajeRecibido = new String(datagramaEntrada.getData()).trim();
        int numero = Integer.parseInt(mensajeRecibido);

        System.out.println("(Servidor): Enviando datagrama...");
        byte[] mensajeEnviado=null ;

        if(numero==numeroAleatorio){
            System.out.println();
            mensajeEnviado=  new String("Has adivinado el número").getBytes();

        } else if (numero<numeroAleatorio) {
            System.out.println();
            mensajeEnviado= new String("El numero es menor que el aleatorio").getBytes();
        }else if (numero>numeroAleatorio) {
            System.out.println();
            mensajeEnviado= new String("El numero es mayor que el aleatorio").getBytes();

        }
        DatagramPacket packetSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,
                datagramaEntrada.getAddress(), datagramaEntrada.getPort());
        try {
            socket.send(packetSalida);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
