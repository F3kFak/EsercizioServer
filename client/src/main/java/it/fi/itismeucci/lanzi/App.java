package it.fi.itismeucci.lanzi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ClientStr cliente = new ClientStr();
        cliente.connetti();
        cliente.comunica();
    }
}
