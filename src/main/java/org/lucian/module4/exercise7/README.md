# Chain of Responsibility Pattern - Logging Framework

## Panoramica
Il **Chain of Responsibility** è un pattern comportamentale che permette di passare richieste lungo una catena di gestori. Quando una richiesta viene ricevuta, ogni gestore decide se processarla o passarla al prossimo gestore nella catena.

## Struttura dell'Implementazione

### 1. Classe Astratta `Logger`
```java
public abstract class Logger {
    protected LogLevel logLevel;
    protected Logger nextLogger;
    
    public void logMessage(LogLevel level, String message) {
        if (this.logLevel == level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
    
    protected abstract void write(String message);
}
```

**Responsabilità:**
- Definisce l'interfaccia comune per tutti i gestori
- Mantiene il riferimento al prossimo gestore nella catena
- Implementa la logica di inoltro delle richieste

### 2. Implementazioni Concrete

#### `ConsoleLogger` (Livello INFO)
- Gestisce messaggi informativi
- Output: console standard
- Utilizzato per: log di sistema generali, debug, informazioni di stato

#### `FileLogger` (Livello WARNING)  
- Gestisce avvertimenti
- Output: file di log con timestamp
- Utilizzato per: situazioni che richiedono attenzione ma non bloccano il sistema

#### `EmailLogger` (Livello ERROR)
- Gestisce errori critici
- Output: simulazione invio email
- Utilizzato per: errori che richiedono intervento immediato

### 3. Enum `LogLevel`
```java
public enum LogLevel {
    INFO, WARNING, ERROR
}
```

## Vantaggi del Pattern

### 1. **Disaccoppiamento**
- Il mittente non conosce quale gestore elaborerà la richiesta
- I gestori non dipendono l'uno dall'altro direttamente
- Facile aggiunta/rimozione di gestori

### 2. **Flessibilità nella Configurazione**
```java
// Configurazione dinamica della catena
Logger chain = new ConsoleLogger();
chain.setNextLogger(new FileLogger("app.log"));
chain.setNextLogger(new EmailLogger("admin@company.com"));
```

### 3. **Responsabilità Singola**
- Ogni logger ha una responsabilità specifica
- Facile manutenzione e testing
- Codice più leggibile e organizzato

### 4. **Estensibilità**
- Nuovi tipi di logger possono essere aggiunti senza modificare il codice esistente
- Supporta il principio Open/Closed

## Esempio di Utilizzo

```java
// Creazione della catena
Logger loggerChain = getLoggerChain();

// Utilizzo
loggerChain.logMessage(LogLevel.INFO, "Application started");
loggerChain.logMessage(LogLevel.WARNING, "Memory usage high");
loggerChain.logMessage(LogLevel.ERROR, "Database connection failed");
```

## Varianti Avanzate

### Multi-Level Logger
```java
static class MultiLevelLogger extends Logger {
    @Override
    public void logMessage(LogLevel level, String message) {
        // Gestisce tutti i livelli
        write("[MULTI-LEVEL " + level + "] " + message);
        
        // Continua la catena
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }
}
```

### Gestori Condizionali
- Possibilità di aggiungere logica condizionale
- Filtri basati su contenuto del messaggio
- Gestione di priorità multiple

## Confronto con Altri Pattern

### vs Strategy Pattern
- **Chain of Responsibility**: Sequenza di gestori, un messaggio può essere processato da più gestori
- **Strategy**: Un algoritmo alla volta, scelta esplicita della strategia

### vs Observer Pattern  
- **Chain of Responsibility**: Catena lineare, controllo del flusso
- **Observer**: Notifica broadcast, tutti gli observer vengono notificati

## Considerazioni di Design

### Pro:
- ✅ Disaccoppiamento mittente-ricevitore
- ✅ Flessibilità nella configurazione
- ✅ Rispetta principi SOLID
- ✅ Facile testing individuale dei gestori

### Contro:
- ❌ Performance: ogni richiesta attraversa la catena
- ❌ Debugging più complesso
- ❌ Possibili catene circolari se mal configurate
- ❌ Nessuna garanzia che una richiesta venga gestita

## Applicazioni Reali

1. **Logging Frameworks** (Log4j, SLF4J)
2. **Gestione Eventi GUI** (event bubbling)
3. **Middleware nelle applicazioni web**
4. **Sistemi di approvazione workflow**
5. **Parsing e validazione dati**

## Best Practices

1. **Ordine dei Gestori**: Mettere i gestori più specifici all'inizio
2. **Gestione Errori**: Prevedere gestori di fallback
3. **Performance**: Evitare catene troppo lunghe
4. **Testing**: Testare ogni gestore individualmente
5. **Documentazione**: Documentare l'ordine e le responsabilità

Questo pattern è particolarmente utile quando hai una serie di oggetti che potrebbero gestire una richiesta, ma non sai a priori quale sarà il gestore appropriato.
