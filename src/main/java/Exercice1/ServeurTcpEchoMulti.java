package Exercice1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServeurTcpEchoMulti {

    ExecutorService pool = Executors.newFixedThreadPool(3);

    public void demarrer() throws IOException {
        ServerSocket serveur = new ServerSocket(50007);
        for(int i = 0; i<10 ; i++){
            Socket client = serveur.accept();
            ThreadServeurEcho monThread = new ThreadServeurEcho(client);
            pool.execute(monThread);
        }
    }
}
