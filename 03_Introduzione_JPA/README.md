# 03 - Introduzione alle JPA

## Alternativa all'uso di MySQL

L'esempio mostrato nel video usa un database MySQL. Se non avete un database MySQL potete usare un altro database. La scelta di default per Netbeans è Apache Derby, un semplice database che solitamente è incluso nell'installazione di Java.

### Configurare l'esempio con Apache Derby

* Nel file `pom.xml` decommentate le dipendenze per il driver di Derby.

* Nel file `src/main/resources/META-INF/persistence.xml` commentate la configurazione di MySQL e decommentate quella per Derby.

* Create un database dentro Derby chiamato "jpademo". Con Netbeans si fa così:
    * Window --> Services --> Databases --> Java DB --> Tasto destro --> Create database
    * Qui create un database con nome database, utente e password "jpademo". Non lasciate username e password vuoti sennò vi darà errore durante l'esecuzione.
