package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ManipuladorArquivoTexto {

    private static final String DEFAULT_CHARSET = "ISO-8859-1"; //Mais utilizados: "ISO-8859-1" (Windows) e "UTF8" (UNIX);
    private static final String DELIMITADOR = ","; //Mais utilizados: espa�o (" "), Tabula��o ("\t"), v�rgula (",") e ponto e v�rgula (";")

    public static void escrever(String linha, String nomeArquivo) {

        BufferedWriter bw = null;
        final boolean ADICIONAR_AO_FINAL = true;

        try {

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nomeArquivo, ADICIONAR_AO_FINAL), DEFAULT_CHARSET));
            bw.write(linha);
            bw.newLine();
            bw.flush();
        } catch (UnsupportedEncodingException ex1) {
            System.out.println(ex1.getMessage());
        } catch (FileNotFoundException ex2) {
            System.out.println(ex2.getMessage());
        } catch (IOException ex3) {
            System.out.println(ex3.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close(); //tenta fechar o arquivo
                } catch (IOException e) {
                    System.out.println("Erro ao tentar fechar o arquivo. Motivo: " + e.getMessage());
                }
            }
        }
    }

    public static ArrayList<String> ler(final String nomeArquivo) {

        BufferedReader br = null;
        int contaLinhas = 0;
        ArrayList<String> linhasArq = new ArrayList<>();
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(nomeArquivo)), DEFAULT_CHARSET));

            String linha = br.readLine(); // tenta ler a primeira linha

            // Testa se existe uma linha a ser lida
            while (linha != null) {
                linhasArq.add(linha);
                linha = br.readLine(); // tenta ler a pr�xima linha
                contaLinhas++;
            }
            //System.out.println("N�mero total de linhas lidas: " + contaLinhas);
        } catch (UnsupportedEncodingException ex1) {
            System.out.println(ex1.getMessage());
        } catch (FileNotFoundException ex2) {
            System.out.println(ex2.getMessage());
        } catch (IOException ex3) {
            System.out.println(ex3.getMessage());
        } finally {

            if (br != null) {
                try {
                    br.close(); //tenta fechar o arquivo
                } catch (IOException e) {
                    System.out.println("Erro ao tentar fechar o arquivo. Motivo: " + e.getMessage());
                }
            }
        }

        return linhasArq;
    }

    public static void lerTextoComDelimitador(final String nomeArquivo) {

        BufferedReader br = null;
        String[] tokens = null;
        try {

            String linha;
            int contaLinhas = 0;

            br = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), DEFAULT_CHARSET));

            while ((linha = br.readLine()) != null) {

                tokens = linha.split(DELIMITADOR);

                // Cada dado (tamb�m chamado de token), que estava separado pelo dilimitador, estar� em uma posi��o do vetor 
                for (String dado : tokens) {
                    System.out.println(dado);
                }

                contaLinhas++;
            }
            System.out.println(contaLinhas);
            //System.out.println("N�mero total de linhas lidas: " + contaLinhas);
        } catch (UnsupportedEncodingException ex1) {
            System.out.println(ex1.getMessage());
        } catch (FileNotFoundException ex2) {
            System.out.println(ex2.getMessage());
        } catch (IOException ex3) {
            System.out.println(ex3.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close(); //tenta fechar o arquivo
                } catch (IOException e) {
                    System.out.println("Erro ao tentar fechar o arquivo. Motivo: " + e.getMessage());
                }
            }
        }
    }

    public static void excluirMusica(final String nomeArquivo, int linha) throws IOException {
        ArrayList<String> linhasArq = ler(nomeArquivo);
        try {
            FileWriter fw = new FileWriter(nomeArquivo, true);
            fw.close();
   
            File f = new File("arquivo.txt");
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < linhasArq.size(); i++) {
                if (i != linha) {
                    bw.write(linhasArq.get(i));
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception ex1) {
            System.out.println(ex1.getMessage());
        }

    }
}
