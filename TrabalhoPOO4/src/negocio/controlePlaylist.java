package negocio;

import repositorio.repositorioPlaylist;

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
}
