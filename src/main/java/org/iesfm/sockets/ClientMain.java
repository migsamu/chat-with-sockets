package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    private final static Logger log = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {
        String serverIp = "localhost";
        int port = 4000;

        try {
            log.info("Arrancando cliente...");
            Socket socket = new Socket(serverIp, port);

            ChatApp app = new ChatApp(socket);
            app.startChatApp();
          /*  WriteToSocketTask askTask = new WriteToSocketTask(new Scanner(System.in), socket);
            ReadFromSocketTask sendTask = new ReadFromSocketTask(socket);
            Thread t1 = new Thread(askTask);
            Thread t2 = new Thread(sendTask);
            t1.start();
            t2.start();
           */

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
