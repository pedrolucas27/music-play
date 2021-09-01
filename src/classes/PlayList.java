package classes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PlayList implements Serializable {

    private int id;
    private String nome;

    public PlayList() {

    }

    public PlayList(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return id + ";" + nome;
    }

    public boolean inserir(Musica m) {
        boolean flag = true;
        ArrayList<String> linhasArq = ManipuladorArquivoTexto.ler("arquivo.txt");
        if (linhasArq.size() == 2) {
            ManipuladorArquivoTexto.escrever(m.toString(), "arquivo.txt");
        } else {
            for (int i = 2; i < linhasArq.size(); i++) {
                String[] partesMus = linhasArq.get(i).split(";");
                if (Integer.parseInt(partesMus[1]) == m.getId()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ManipuladorArquivoTexto.escrever(m.toString(), "arquivo.txt");
            }
        }
        return flag;
    }

    public boolean remover(Musica m) throws IOException {
        boolean flag = false;
        ArrayList<String> linhasArq = ManipuladorArquivoTexto.ler("arquivo.txt");
        if (linhasArq.size() > 2) {
            for (int i = 2; i < linhasArq.size(); i++) {
                String[] partesMus = linhasArq.get(i).split(";");
                if (Integer.parseInt(partesMus[1]) == m.getId()) {
                    ManipuladorArquivoTexto.excluirMusica("arquivo.txt", i);
                    flag = true;
                    break;
                }
            }
        } else {
            System.out.println("ESTE ARQUIVO NÃO CONTÉM MÚSICA!!");
        }
        return flag;
    }

    public ArrayList<Musica> listar() {
        ArrayList<String> linhasArq = ManipuladorArquivoTexto.ler("arquivo.txt");
        ArrayList<Musica> musicas = new ArrayList<>();
        for (int i = 2; i < linhasArq.size(); i++) {
            String[] partes = linhasArq.get(i).split(";");
            Genero g = new Genero(Integer.parseInt(partes[4]), partes[3]);
            Musica m = new Musica(Integer.parseInt(partes[1]), partes[0], Integer.parseInt(partes[2]), g);
            musicas.add(m);
        }
        return musicas;
    }

    public int calcularDuracao() {
        ArrayList<String> linhasArq = ManipuladorArquivoTexto.ler("arquivo.txt");
        int tempo = 0;
        for (int i = 2; i < linhasArq.size(); i++) {
            String[] partes = linhasArq.get(i).split(";");
            tempo += Integer.parseInt(partes[2]);
        }
        return tempo;
    }

}
