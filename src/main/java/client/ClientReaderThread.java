package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private final Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();

        boolean isRunning = true;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while ( isRunning ) {

                    if (socket.isClosed()) {
                        isRunning = false;
                        continue;
                    }
                    String receivedMessage = reader.readLine();

                    if(receivedMessage != null) {
                        System.out.println(receivedMessage);
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
