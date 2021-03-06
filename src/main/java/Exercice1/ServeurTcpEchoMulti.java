package Exercice1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurTcpEchoMulti {

    private int port;
    private int nbClients;

    public ServeurTcpEchoMulti(int port, int nbClients) {
        this.port = port;
        this.nbClients = nbClients;
    }

    public void demarrer() throws IOException {

        ServerSocket serveur = new ServerSocket(port);

        System.out.println("Serveur TCP Echo multi-threads lancé sur le port " + port);

        for(int i = 0; i<= nbClients ; i++){

            Socket client = serveur.accept();
            ThreadServeurEcho monThread = new ThreadServeurEcho(client);
            monThread.start();

        }

        serveur.close();
    }
}
