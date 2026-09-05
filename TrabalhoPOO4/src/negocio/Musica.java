package negocio;

import java.util.ArrayList;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private int notaAtual;
    private Genero genero;
    private ArrayList<Avaliacao> Avaliacoes;

    private static int geraId = 0;

    public Musica(String nome, String artista, Genero genero) { // init / Cadastrar
        id = geraId++;

        this.nome = nome;
        this.artista = artista;
        this.genero = genero;

        notaAtual = 0;
        Avaliacoes = new ArrayList<>();
    }

    public Musica(Musica m) {
        this.id = m.id;
        this.nome = m.nome;
        this.artista = m.artista;
        this.notaAtual = m.notaAtual;
        this.genero = m.genero;

        this.Avaliacoes = new ArrayList<>();

        for (int i = 0; i < )
    }

    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Artista: " + artista);
        System.out.println("Genero: " + genero);
    }
}
