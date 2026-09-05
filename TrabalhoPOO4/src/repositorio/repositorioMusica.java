package repositorio;

import negocio.Musica;

import java.util.ArrayList;

public class repositorioMusica {
    private ArrayList<Musica> musicas;

    public repositorioMusica() {
        musicas = new ArrayList<>();
    }

    public ArrayList<Musica> getMusicas() {
        ArrayList<Musica> copia = new ArrayList<>();

        for (int i = 0; i < musicas.size(); i++){
            copia.add(new Musica(musicas.get(i)));
        }

        return null;
    }
}
