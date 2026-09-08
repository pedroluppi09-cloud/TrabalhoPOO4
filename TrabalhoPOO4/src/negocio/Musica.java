package negocio;

import java.util.ArrayList;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private int notaAtual;
    private Genero genero;
    private ArrayList<Avaliacao> Avaliacoes;

    private static int geraId = 1;

    public Musica(String nome, String artista, Genero genero) {
        this.id = geraId++;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;

        this.notaAtual = 0;
        this.Avaliacoes = new ArrayList<>();
    }

    public Musica(Musica m) {
        this.id = m.id;
        this.nome = m.nome;
        this.artista = m.artista;
        this.notaAtual = m.notaAtual;
        this.genero = m.genero;

        this.Avaliacoes = new ArrayList<>();

        for (int i = 0; i < m.Avaliacoes.size(); i++){
            this.Avaliacoes.add(new Avaliacao(m.Avaliacoes.get(i)));
        }
    }

    public static Musica getInstance(String nome, String artista, Genero genero) {
        if (nome.isEmpty() && artista.isEmpty() && genero == null){
            return null;
        } else {
            return new Musica(nome, artista, genero);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getNotaAtual() {
        return notaAtual;
    }

    public int getId() {
        return id;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean verPrefixoComum(String parte, ArrayList<Musica> resultado) {
        String comparaParte = "";
        boolean existe = false;

        if (parte.length() <= nome.length()){
            // Primeira parte: comparar a string
            for (int i = 0; i < parte.length(); i++){
                comparaParte += String.valueOf(nome.charAt(i));
            }

            if (comparaParte.equalsIgnoreCase(parte)){
                // Segunda parte: ver se já está inserido em resultado

                for (int i = 0; i < resultado.size(); i++){
                    if (id == resultado.get(i).getId()){
                        existe = true;
                        break;
                    }
                }

                return !existe;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
