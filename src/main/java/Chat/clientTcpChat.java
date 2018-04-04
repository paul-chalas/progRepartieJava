package Chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class clientTcpChat {
    private String hostname;
    private int port;

    public clientTcpChat(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connecter() throws IOException {

        Socket sockClient = new Socket(hostname, port);
        System.out.println("Vous êtes connecté !");

        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

        String bufSend;
        String bufReceived;

        while(true){

            System.out.print("Vous : ");
            bufSend = clavier.readLine();

            out.write(bufSend);
            out.newLine();
            out.flush();

            if(bufSend.toLowerCase().equals("quit")) {
                System.out.println("Vous avez quitté le chat !");
                break;
            }

            bufReceived = in.readLine();
            if(bufReceived.toLowerCase().equals("quit")){
                System.out.println("L'autre utilisateur à quitté le chat !");
                break;
            }

            System.out.print("Reçu : ");
            System.out.println(bufReceived);
        }

        System.out.println("Disconnected...");

        out.close();
        in.close();
        sockClient.close();
    }
}
