package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;

public class ClientStr {
    
    String nomeServer = "localhost"; // indirizzo server locale
    int portaServer = 12121; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtente; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input

    /*
    public Socket connetti() {
        System.out.println("2 CLIENT partito in esecuzione ...");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host Sconosciuto");
        } catch (Exception e) {

        }
        return miosocket;
    }*/

    public void comunica() throws IOException {
        
        Comunica C1 = new Comunica();
        ThreadInput ti = new ThreadInput(C1);
        ThreadOutput to = new ThreadOutput(C1);

        to.start();
        ti.start();
            /*try {
                for (;;) {
                System.out.println("4 ... inserisci la stringa da trasmettere al server" + '\n');
                StringaUtente = tastiera.readLine();
                if (!StringaUtente.equals("fine") && !StringaUtente.equals("spegni")) {
                    System.out.println("5 ... invio la stringa al server e attendo ... ");
                    outVersoServer.writeBytes(StringaUtente + '\n');
                    StringaRicevutaDalServer = inDalServer.readLine();
                    System.out.println("8 ... risposta dal server " + '\n' + StringaRicevutaDalServer);
                }
                else {
                    outVersoServer.writeBytes(StringaUtente + '\n');
                    miosocket.close();
                    System.out.println("FINE");
                    break;
                }
                
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Errore durante la connessione");
                System.exit(1);
            }*/
    }
}

