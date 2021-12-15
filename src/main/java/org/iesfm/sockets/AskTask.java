package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AskTask implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(AskTask.class);

    private Scanner scanner;
    private Socket socket;

    public AskTask(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            while (true) {
                log.info("Escribe un mensaje");
                String message = scanner.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
