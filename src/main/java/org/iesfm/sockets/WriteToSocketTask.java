package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteToSocketTask implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(WriteToSocketTask.class);

    private Scanner scanner;
    private Socket socket;
    private String alias;


    public WriteToSocketTask (Socket socket, Scanner scanner, String alias) {
        this.socket = socket;
        this.scanner = scanner;
        this.alias = alias;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            String message = null;

            while(!":quit".equals(message)) {
                message = scanner.nextLine();
                writer.println(alias +": " + message);
                writer.flush();
            }
        } catch (IOException e) {
            log.error("Error al enviar mensaje", e);
        }

    }
}
