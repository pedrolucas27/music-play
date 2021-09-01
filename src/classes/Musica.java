package classes;


public class Musica {
    
    private int id;
    private String titulo;
    private int duracao;
    private Genero genero;

    public Musica() {
        
    }

    public Musica(int id, String titulo, int duracao, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.titulo+";"+this.id+";"+this.duracao+";"+genero.getNome()+";"+genero.getId(); 
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Musica){
           Musica f = (Musica) obj;
           return this.titulo.equals(f.getTitulo());
        }else{
           return false; 
        }
    }     
}
