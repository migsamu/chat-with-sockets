package org.iesfm.sockets;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        String serverIp = "localhost";
        int port = 4000;

        try {
            Socket socket = new Socket(serverIp, port);
            AskTask askTask = new AskTask(new Scanner(System.in), socket);
            SendTask sendTask = new SendTask(socket);
            Thread t1 = new Thread(askTask);
            Thread t2 = new Thread(sendTask);
            t1.start();
            t2.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
