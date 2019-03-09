package net.zonia3000.mvc;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class MyController {

    @GetMapping("/saluta/{nome}")
    public Utente saluta(@PathVariable("nome") String nome) {
        Utente u = new Utente();
        u.setNome(nome);
        return u;
    }

    /**
     * Potete testare la chiamata in POST ad esempio usando curl o tool più
     * evoluti come Postman.
     *
     * Chiamata curl valida:
     * <code>curl --header "Content-Type: application/json" --data '{"nome":"pluto"}' http://localhost:8080/base</code>
     *
     * Chiamata curl NON valida (nome utente null):
     * <code>curl --header "Content-Type: application/json" --data '{"nome":null}' http://localhost:8080/base</code>
     * Questo vi restituirà un errore contentente anche il messaggio presente
     * nell'annotazione @NotNull definita nella classe Utente sopra il field
     * nome.
     *
     * Notate l'uso dell'annotazione @Valid per richiedere che il corpo della
     * richiesta venga validato.
     */
    @PostMapping
    public ResponseEntity<Utente> utenteInPost(@Valid @RequestBody Utente utente) {
        return new ResponseEntity<>(utente, HttpStatus.CREATED);
    }

    /**
     * Esempio di conversione in XML (di default va sempre in JSON). Per far
     * funzionare questo endpoint ho aggiunto nel pom.xml la dipendenza
     * jackson-dataformat-xml.
     */
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Utente utenteInXML() {
        Utente u = new Utente();
        u.setNome("xml");
        return u;
    }
}
