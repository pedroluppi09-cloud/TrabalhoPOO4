package negocio;

import repositorio.RepositorioPlaylist;

import java.util.ArrayList;

public class ControlePlaylist {
    private RepositorioPlaylist rPlaylist = new RepositorioPlaylist();

    public boolean add(Playlist P, int idU) {
        if (rPlaylist.encontrarPlaylistNomeIgual(P, idU, 'C')){
            System.out.println("Não é possível adicionar a playlist (Nome Repetido)");
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

    public boolean alterar(Playlist P, int idU) {
        if (rPlaylist.encontrarPlaylistNomeIgual(P, idU, 'E')){
            System.out.println("Não é possível editar a musica (Nome Repetido)");
            return false;
        } else {
            rPlaylist.edit(P);
            return true;
        }
    }

    public boolean excluir(Playlist P) {
        rPlaylist.excluir(P);
        return true;
    }

    public void atualizarMusica(Musica M) {
        rPlaylist.atualizarMusica(M);
    }
}
