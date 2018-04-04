package Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurTcpChat {

    private int port;

    public serveurTcpChat(int port) {
        this.port = port;
    }


    public void demarrer() throws IOException {
        Socket client;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Serveur de chat lancé sur le port " + port);

        client = server.accept();

        System.out.println("Client " + client.getInetAddress().getHostAddress());

        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String bufSend;
        String bufReceived;

        while(true){

            bufReceived = in.readLine();
            if(bufReceived.toLowerCase().equals("quit")){
                System.out.println("L'autre utilisateur à quitté le chat !");
                break;
            }

            System.out.print("Reçu : ");
            System.out.println(bufReceived);

            System.out.print("Vous : ");
            bufSend = clavier.readLine();

            out.write(bufSend);
            out.newLine();
            out.flush();

            if(bufSend.toLowerCase().equals("quit")) {
                System.out.println("Vous avez quitté le chat !");
                break;
            }
        }

        client.close();
        server.close();
    }
}
