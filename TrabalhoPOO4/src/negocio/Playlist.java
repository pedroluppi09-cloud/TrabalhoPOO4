package negocio;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Musica> musicas;
    private Usuario UsuarioCriou;
    private ArrayList<Usuario> UsuariosCompartilhados;

    private static int geraId = 1;

    private Playlist(String nome, String descricao, Usuario u) {
        id = geraId++;
        this.nome = nome;
        this.descricao = descricao;

        musicas = new ArrayList<>();
        UsuariosCompartilhados = new ArrayList<>();

        UsuarioCriou = new Usuario(u);
    }

    public static Playlist getInstance(String nome, String descricao, Usuario u) {
        if (nome.isEmpty() || descricao.isEmpty()){
            return new Playlist(nome, descricao, u);
        } else {
            return null;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public Usuario getUsuarioCriou() {
        return UsuarioCriou;
    }

    public ArrayList<Usuario> getUsuariosCompartilhados() {
        return UsuariosCompartilhados;
    }
}
