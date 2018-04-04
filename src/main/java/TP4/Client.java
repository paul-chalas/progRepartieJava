package TP4;

import java.io.*;
import java.net.Socket;

public class Client {

    private String ip;
    private int port;
    private Socket sockClient;

    public Client(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
    }

    public void getFile(String fileName, String dest) throws IOException {
        sockClient = new Socket(ip, port);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));
        bw.write(fileName);
        bw.newLine();
        bw.flush();
        InputStream inServeur = sockClient.getInputStream();
        byte buf[] = new byte[512];
        int nbOctet = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        while ((nbOctet = inServeur.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, nbOctet);
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("10.203.9.145", 2000);

        client.getFile("image1.jpeg", "img.jpeg");
    }
}
