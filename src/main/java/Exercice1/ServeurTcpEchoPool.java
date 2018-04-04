package Exercice1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurTcpEchoPool {

    private int port;
    private int nbClients;
    private int threads;

    public ServeurTcpEchoPool(int port, int nbClients, int threads) {
        this.port = port;
        this.nbClients = nbClients;
        this.threads = threads;
    }

    public void demarrer() throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(threads);

        ServerSocket serveur = new ServerSocket(port);

        System.out.println("Serveur TCP Echo avec pool de threads lancé sur le port " + port);

        for(int i = 0; i<= nbClients ; i++){

            Socket client = serveur.accept();
            ThreadServeurEcho monThread = new ThreadServeurEcho(client);

            pool.execute(monThread);
        }

        serveur.close();
    }
}
