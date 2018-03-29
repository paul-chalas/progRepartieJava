package Exercice1;

import java.io.IOException;

public class main {

    public static void main (String[] agrs) throws IOException {

        //ServeurTcpEchoMulti serveur = new ServeurTcpEchoMulti();
        //serveur.demarrer();

        ClientTcpEcho test = new ClientTcpEcho("10.203.9.90",50007);
        test.send();
    }
}
