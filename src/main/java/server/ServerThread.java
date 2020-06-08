package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread implements SendMessage {
    private final ServerClientThread[] clients = new ServerClientThread[2];

    @Override
    public void run() {
        super.run();

        System.out.println("Server running ... ");
        boolean isConnected = true;
        int connectedClients = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(9090);

            while (isConnected) {
                if(serverSocket.isClosed()) {
                    isConnected = false;
                    continue;
                }

                if(connectedClients <= 1) {
                    Socket client = serverSocket.accept();

                    ServerClientThread clientThread = new ServerClientThread(client, this);
                    clientThread.start();
                    clients[connectedClients++] = clientThread;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message, long threadId) {
        for(ServerClientThread client: clients) {
            if(client == null)continue;
            if(client.getId() == threadId) continue;

            client.sendMessageToClient(message);
        }
    }
}
