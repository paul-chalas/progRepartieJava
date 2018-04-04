package SMTP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main (String[] agrs) throws IOException, InterruptedException {
        ClientSmtp clientSmtp = new ClientSmtp("139.124.187.23",25,"jupiter");
        while(true){
            clientSmtp.send("LAPORTE Marc <marc.laporte@univ-amu.fr>", "pech", "Exclusion", "Salut mon p'tit Guigui, j'ai le plaisir de t'annoncer que tu es exclu de l'IUT pour tes médiocres perfomances...");
            //TimeUnit.MILLISECONDS.sleep(300);
        }


    }
}
