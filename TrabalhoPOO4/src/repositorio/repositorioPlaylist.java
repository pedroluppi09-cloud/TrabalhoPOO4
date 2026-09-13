package repositorio;

import negocio.Playlist;

import java.util.ArrayList;

public class repositorioPlaylist {
    ArrayList<Playlist> playlists = new ArrayList<>();

    public boolean encontrarPlaylistNomeIgual(Playlist P, int idU) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getUsuarioCriou().getId() == idU &&
                    P.getNome().equalsIgnoreCase(playlists.get(i).getNome())){
                return true;
            }
        }

        return false;
    }

    public void add(Playlist p) {
        playlists.add(p);
    }
}
