package Chat;

import java.io.IOException;

public class main {

    public static void main (String[] agrs) throws IOException {
        //serveurTcpChat serveurTcpChat = new serveurTcpChat(50007);
        //serveurTcpChat.demarrer();

        clientTcpChat clientTcpChat = new clientTcpChat("10.203.9.189",50007);
        clientTcpChat.connecter();

    }
}
