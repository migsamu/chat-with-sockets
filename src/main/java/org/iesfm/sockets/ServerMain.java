package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {

    private final static Logger log = LoggerFactory.getLogger(ServerMain.class);


    public static void main(String[] args) {
        int port = 4000;

        try {
            log.info("Arrancando servidor.");
            ServerSocket ss = new ServerSocket(port);
            log.info("Esperando conexión...");
            Socket socket = ss.accept();

            ChatApp app = new ChatApp(socket);
            app.startChatApp();

          /*  WriteToSocketTask askTask = new WriteToSocketTask(new Scanner(System.in), socket);
            ReadFromSocketTask sendTask = new ReadFromSocketTask(socket);
            Thread t1 = new Thread(askTask);
            Thread t2 = new Thread(sendTask);
            t1.start();
            t2.start();

           */


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
