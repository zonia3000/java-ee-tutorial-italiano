package net.zonia3000.mvc;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class Utente {

    @NotNull(message = "Il nome utente non puo' essere null")
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    public Utente() {
        createdAt = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
