package org.iesfm.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {


    public static void main(String[] args) {
        int port = 4000;

        try {
            ServerSocket ss = new ServerSocket(port);
            Socket socket = ss.accept();
            AskTask askTask = new AskTask(new Scanner(System.in), socket);
            SendTask sendTask = new SendTask(socket);
            Thread t1 = new Thread(askTask);
            Thread t2 = new Thread(sendTask);
            t1.start();
            t2.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
