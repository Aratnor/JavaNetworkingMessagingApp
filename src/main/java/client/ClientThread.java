package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientThread extends Thread{

    @Override
    public void run() {
        super.run();

        try {
            InetAddress localServer = InetAddress.getLocalHost();
            Socket socket = new Socket(localServer, 9090);

            ClientReaderThread readerThread =new ClientReaderThread(socket);
            readerThread.start();

            boolean isRunning = true;

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            while(isRunning) {
                if(socket.isClosed()) {
                    isRunning = false;
                    continue;
                }

                String message = scanner.nextLine();

                if(message != null) {
                    writer.println(message);
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
