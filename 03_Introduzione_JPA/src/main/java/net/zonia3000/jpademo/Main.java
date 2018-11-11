package net.zonia3000.jpademo;

import java.util.List;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        Utente utente1 = new Utente();
        utente1.setUsername("pippo");
        controller.aggiungiUtente(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("pluto");
        controller.aggiungiUtente(utente2);

        Libro libro = new Libro();
        libro.setAutore("Asimov");
        libro.setTitolo("Io, Robot");
        controller.aggiungiLibro(utente2, libro);

        List<Utente> utenti = controller.getUtenti();
        System.out.println("Trovati " + utenti.size() + " utenti\n");
        for (Utente utente : utenti) {
            System.out.println(utente.getUsername());
        }

        System.out.println("----\n");

        System.out.println("L'id di pippo e': " + controller.getUtenteByName("pippo").getId());
        
        controller.close();
    }
}
