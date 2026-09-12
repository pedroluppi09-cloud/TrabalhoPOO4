package negocio;

import java.util.ArrayList;

public class Avaliacao {
    private int id;
    private String descricao;
    private int nota;
    private Musica Musica;
    private Usuario Usuario;

    private static int geraId = 1;

    public Avaliacao(Avaliacao a) { // copia
        this.id = a.id;
        this.descricao = a.descricao;
        this.nota = a.nota;
        this.Usuario = new Usuario(a.Usuario);
        this.Musica = new Musica(a.Musica);
    }

    public Avaliacao(int nota, String descricao, Musica m, Usuario u) {
        this.id = geraId++;
        this.nota = nota;
        this.descricao = descricao;
        this.Musica = m;
        this.Usuario = u;
    }

    public static Avaliacao getInstance(int nota, String descricao, Musica musicaEsc, Usuario u) {
        if ((nota < 0 || nota > 10) || descricao.isEmpty() || musicaEsc == null || u == null){
            return null;
        } else {
            return new Avaliacao(nota, descricao, musicaEsc, u);
        }
    }

    public Musica getMusica() {
        return new Musica(Musica);
    }

    public Usuario getUsuario() {
        return new Usuario(Usuario);
    }
}
