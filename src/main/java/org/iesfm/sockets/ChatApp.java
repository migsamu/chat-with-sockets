package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;
import java.util.Scanner;

public class ChatApp {
    private final static Logger log = LoggerFactory.getLogger(ChatApp.class);

    private Socket socket;

    public ChatApp(Socket socket) {
        this.socket = socket;
    }

    public void startChatApp() {
        Scanner scanner = new Scanner(System.in);
        log.info("Introduce tu alias");
        String alias = scanner.nextLine();
        Thread readThread = new Thread(new ReadFromSocketTask(socket));
        Thread writeThread = new Thread(new WriteToSocketTask(socket, scanner, alias));

        readThread.start();
        writeThread.start();
    }
}
