package ejercicio1;

import javax.annotation.processing.Filer;
import javax.annotation.processing.FilerException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        String infoCliente = "";

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

            String ruta = br.readLine();

            File texto = new File(ruta);
            FileReader fr = new FileReader(texto);
            br = new BufferedReader(fr);

            String linea;
            while((linea = br.readLine())!=null){
                infoCliente+=linea;
            }

            bw.write(infoCliente);
            bw.newLine();
            bw.flush();

            fr.close();
            br.close();
            isr.close();
            is.close();
            os.close();
            socketCliente.close();
            socketServidor.close();

        }catch (Exception e){

        }
    }
}
