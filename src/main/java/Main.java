import client.ClientThread;
import server.ServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String [] args) {
        try {
            if(args.length > 0) {
                String firstArg = args[0];

                if(firstArg.equals("Server")) {
                    ServerThread serverThread = new ServerThread();
                    serverThread.start();
                } else if(firstArg.equals("Client")) {
                    ClientThread clientThread = new ClientThread();
                    clientThread.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void myPublicIp() throws IOException {

        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        String ip = in.readLine(); //you get the IP as a String
        System.out.println(ip);
        whatismyip = new URL("http://myexternalip.com/raw");
        in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

        ip = in.readLine();

        System.out.println(ip);
    }
}
