package repositorio;

import negocio.Musica;

import java.util.ArrayList;

public class repositorioMusica {
    private ArrayList<Musica> musicas;

    public repositorioMusica() {
        musicas = new ArrayList<>();
    }

    public void add(Musica M) {
        musicas.add(M);
    }

    public ArrayList<Musica> getMusicas() {
        ArrayList<Musica> copia = new ArrayList<>();

        for (int i = 0; i < musicas.size(); i++){
            copia.add(new Musica(musicas.get(i)));
        }

        return copia;
    }

    public boolean encontrarMusicaNomeArtistaIguais(Musica M) {
        boolean NomeEArtistaRepete = false;

        for (int i = 0; i < musicas.size(); i++){
            if (M.getNome().equalsIgnoreCase(musicas.get(i).getNome()) &&
            M.getArtista().equalsIgnoreCase(musicas.get(i).getArtista())){
                NomeEArtistaRepete = true;
                break;
            }
        }

        return NomeEArtistaRepete;
    }
}
