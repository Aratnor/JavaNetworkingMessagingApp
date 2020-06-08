package server;


import java.io.*;
import java.net.Socket;

public class ServerClientThread extends Thread {
    private final Socket socket;
    private final SendMessage messageSender;
    private PrintWriter printWriter;
    private BufferedReader reader;

    public ServerClientThread(Socket socket, SendMessage messageSender) {
        this.socket = socket;
        this.messageSender = messageSender;
        try {
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        printWriter.println("Welcome Client");
        try {
            while(!socket.isClosed()) {
                String clientMessage = reader.readLine();
                messageSender.sendMessage(clientMessage,this.getId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessageToClient(String message) {

        if(message != null) {
            printWriter.println("Sender " + this.getId() + " : " + message);
        }
    }

}
