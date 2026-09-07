package negocio;

import java.util.ArrayList;

public class Avaliacao {
    private int id;
    private Usuario Usuario;
    private String descricao;
    private int nota;

    public Avaliacao(Avaliacao a) { // copia
        this.id = a.id;
        this.descricao = a.descricao;
        this.nota = a.nota;
        this.Usuario = new Usuario(a.Usuario);
    }
}
