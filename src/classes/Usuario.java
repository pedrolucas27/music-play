package classes;


import java.io.Serializable;
import java.util.Date;


public class Usuario implements Serializable{
    
    private int id;
    private String nome;
    private Date dataNasc;

    public Usuario() {
        
    }

    public Usuario(int id, String nome, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return this.id+";"+this.nome+";"+this.dataNasc;
    }
    
}
