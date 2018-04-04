package SMTP;

import java.io.*;
import java.net.Socket;

public class ClientSmtp {

    private String serveurSmtp;
    private int port;
    private String hostname;

    public ClientSmtp(String serveurSmtp, int port, String hostname) {
        this.serveurSmtp = serveurSmtp;
        this.port = port;
        this.hostname = hostname;
    }

    public void send(String from, String to, String subject, String body) throws IOException {

        Socket sockClient = new Socket(serveurSmtp, port);
        System.out.println("Client connecté");

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sockClient.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

        String bufReceived = in.readLine();
        System.out.println(bufReceived);

        write(out, "EHLO " + hostname);
        if (answer(in)){
            return;}

        write(out, "MAIL FROM: <" + from + ">");
        if (answer(in)){
            return;}

        write(out, "RCPT TO: " + to);
        if (answer(in)){
            return;}

        write(out, "DATA");
        if (answer(in)){
            return;}

        write(out, "FROM: " + from + '\n' + "TO: " + to + '\n' + "SUBJECT: " + subject + '\n' + body + '\n' + '.');
        if (answer(in)){
            return;}

        write(out, "QUIT");
        if (answer(in)){
            return;}

        System.out.println("Message envoyé avec succès");
        out.close();
        in.close();
        sockClient.close();
    }
    

    private void write(BufferedWriter bufferedWriter, String content) throws IOException {
        System.out.println(content);
        bufferedWriter.write(content);
        bufferedWriter.newLine();
        bufferedWriter.flush();

    }

    private boolean answer(BufferedReader bufferedReader) throws IOException {

        for(String bufReceived = bufferedReader.readLine(); ; bufReceived = bufferedReader.readLine()){
            System.out.println(bufReceived);

            if(bufReceived.charAt(0) == '4' || bufReceived.charAt(0) == '5'){
                System.out.println("Error...");
                return true;
            }

            if(bufReceived.charAt(3) == ' ')
                break;
        }

        return false;
    }
}
