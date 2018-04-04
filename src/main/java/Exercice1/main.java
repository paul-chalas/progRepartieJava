package Exercice1;

import java.io.IOException;

public class main {

    public static void main (String[] agrs) throws IOException {

        //ServeurTcpEchoMulti serveur = new ServeurTcpEchoMulti();
        //serveur.demarrer();

        //ServeurTcpEcho serveur = new ServeurTcpEcho(50007,20);
        //serveur.demarrer();

        //ServeurTcpEchoPool serveur = new ServeurTcpEchoPool(50007,20,3);
        //serveur.demarrer();

        ClientTcpEcho test = new ClientTcpEcho("10.203.9.152",50007);
        test.send();
    }
}
