package negocio;

import java.util.ArrayList;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private int notaAtual;
    private Genero genero;
    private boolean excluido;

    private static int geraId = 1;

    public Musica(String nome, String artista, Genero genero) {
        this.id = geraId++;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;

        this.notaAtual = 0;
        this.excluido = false;
    }

    public Musica(Musica m) {
        this.id = m.id;
        this.nome = m.nome;
        this.artista = m.artista;
        this.notaAtual = m.notaAtual;
        this.genero = m.genero;
        this.excluido = m.excluido;
    }

    public static Musica getInstance(String nome, String artista, Genero genero) {
        if (nome.isEmpty() || artista.isEmpty() || genero == null){
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

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty())
            this.nome = nome;
    }

    public void setArtista(String artista) {
        if (artista != null && !artista.isEmpty())
            this.artista = artista;
    }

    public void setGenero(Genero genero) {
        if (genero != null)
            this.genero = genero;
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

    public void setExcluido(boolean b) {
        this.excluido = b;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void imprimirColuna(String formato) {
        System.out.printf(formato, id, nome, artista, notaAtual + "/10", genero);
    }
}
