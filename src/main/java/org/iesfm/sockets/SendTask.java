package org.iesfm.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendTask implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(SendTask.class);


    private Socket socket;

    public SendTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = reader.readLine();
            log.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
