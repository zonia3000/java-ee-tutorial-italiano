# 03 - Introduzione alle JPA

## Usare Hibernate invece di EclipseLink

Per usare Hibernate al posto di EclipseLink bisogna:

* andare nel pom.xml, commentare le dipendenze di EclipseLink e decommentare le dipendenze di Hibernate;
* andare nel persistence.xml, commentare il provider di EclipseLink e decommentare il provider di Hibernate.

NOTA: Hibernate ha bisogno di un'opzione `cascade` all'interno della classe Utente. Spiegazioni sul cascade si trovano nel video numero 10.

## Alternativa all'uso di MySQL

L'esempio mostrato nel video usa un database MySQL. Se non avete un database MySQL potete usare un altro database. La scelta di default per Netbeans è Apache Derby, un semplice database che solitamente è incluso nell'installazione di Java.

### Configurare l'esempio con Apache Derby

* Nel file `pom.xml` decommentate le dipendenze per il driver di Derby.

* Nel file `src/main/resources/META-INF/persistence.xml` commentate la configurazione di MySQL e decommentate quella per Derby.

* Create un database dentro Derby chiamato "jpademo". Con Netbeans si fa così:
    * Window --> Services --> Databases --> Java DB --> Tasto destro --> Create database
    * Qui create un database con nome database, utente e password "jpademo". Non lasciate username e password vuoti sennò vi darà errore durante l'esecuzione.
