package Exercice1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcpEcho {

    private int port;
    private int nbClients;

    public ServeurTcpEcho(int port, int nbClients) {
        this.port = port;
        this.nbClients = nbClients;
    }


    public void demarrer() throws IOException {
        Socket client;
        BufferedWriter out;
        BufferedReader in;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Serveur lancé sur le port " + port);

        for (int i = 1; i <= nbClients; i++) {
            client = server.accept();
            System.out.println("Client " + client.getInetAddress().getHostAddress());

            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String messageRecu;

            while((messageRecu = in.readLine()) != null){
                out.write(messageRecu.toUpperCase());
                out.newLine();
                out.flush();
            }
            client.close();

        }
        server.close();
    }
}
