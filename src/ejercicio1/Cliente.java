package ejercicio1;

import jdk.jshell.ImportSnippet;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la ruta del fichero");
        String ruta = sc.nextLine();
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            Socket socketCliente = new Socket(direccion, 50000);

            System.out.println("Abriendo flujos de entrada y salida");
            OutputStream os = socketCliente.getOutputStream();
            InputStream is = socketCliente.getInputStream();

            System.out.println("Enviando mensaje al servidor");
            OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(ruta);

        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
