package negocio;

import repositorio.repositorioPlaylist;

import java.util.ArrayList;

public class controlePlaylist {
    private repositorioPlaylist rPlaylist = new repositorioPlaylist();

    public boolean add(Playlist P, int idU) {
        if (rPlaylist.encontrarPlaylistNomeIgual(P, idU)){
            System.out.println("Não é possível adicionar a musica (Música já cadastrada)");
            return false;
        } else {
            rPlaylist.add(P);
            return true;
        }
    }

    public ArrayList<Playlist> pegarVetor() {
        return rPlaylist.getPlaylists();
    }

    public void addMusica(Playlist p, Musica musicaEsc) {
        rPlaylist.addMusica(p, musicaEsc);
    }

    public void remMusica(Playlist p, int idMusica) {
        rPlaylist.remMusica(p, idMusica);
    }

    public void CompartilharComUsuario(Playlist p, Usuario u) {
        rPlaylist.compartilharComUsuario(p, u);
    }
}
