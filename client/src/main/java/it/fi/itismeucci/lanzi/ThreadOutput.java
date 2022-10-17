package it.fi.itismeucci.lanzi;

public class ThreadOutput extends Thread {
    Comunica comunica;
    public ThreadOutput(Comunica comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Output();
        } catch (Exception e) {}
    }
}
