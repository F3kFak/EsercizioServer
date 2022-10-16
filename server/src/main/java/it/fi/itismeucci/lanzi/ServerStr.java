package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;

public class ServerStr {

    public void avvia() throws IOException {
        System.out.println("1 Server partito in esecuzione ... ");
        ServerSocket server = new ServerSocket(12121);
        for (;;) {
            Socket client;
            try {
                client = server.accept();
                Thread t = new Thread(() -> comunica(client));
                t.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Errore durante l'instanza del server");
                System.exit(1);
            }
        }
    }

    public void comunica(Socket client) {
        try {
            for (;;) {
                BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutput outVersoClient = new DataOutputStream(client.getOutputStream());
                System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiscuolo. Attendo ...");
                String StringaRicevuta = inDalClient.readLine();
                if (!StringaRicevuta.equals("fine")) {
                    System.out.println("6 ricevuta la stringa dal cliente: " + StringaRicevuta);
                    String StringaModificata = StringaRicevuta.toUpperCase();
                    System.out.println("7 invio la stringa modificata al client ...");
                    outVersoClient.writeBytes(StringaModificata + '\n');
                } else {
                    break;
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza del server");
            System.exit(1);
        }
        // server.close();
    }
}