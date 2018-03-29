package Exercice1;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientTcpEcho {

    private String hostname;
    private int port;

    public ClientTcpEcho(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void send() throws IOException {

        Socket sockClient = new Socket();
        sockClient.connect(new InetSocketAddress(hostname, port));
        System.out.println("Client connecté");


        String bufSend;
        String bufReceived;

        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));

        BufferedReader in = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));


        while(true){
            System.out.println("Entrez un texte :");

            bufSend = clavier.readLine();

            if(bufSend.equals("quit"))
                break;
            else {
                out.write(bufSend);

                out.newLine();

                out.flush();

                bufReceived = in.readLine();
                System.out.println(bufReceived);
            }
        }
        System.out.println("Disconnected...");

        out.flush();
        in.close();
        sockClient.close();
    }
}
