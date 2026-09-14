package repositorio;

import negocio.Musica;
import negocio.Playlist;
import negocio.Usuario;

import java.util.ArrayList;

public class RepositorioPlaylist {
    ArrayList<Playlist> playlists = new ArrayList<>();

    public boolean encontrarPlaylistNomeIgual(Playlist P, int idU, char funcao) {
        if (funcao == 'C'){
            for (int i = 0; i < playlists.size(); i++){
                if (playlists.get(i).getUsuarioCriou().getId() == idU &&
                        P.getNome().equalsIgnoreCase(playlists.get(i).getNome())){
                    return true;
                }
            }
        } else {
            for (int i = 0; i < playlists.size(); i++){
                if (playlists.get(i).getUsuarioCriou().getId() == idU &&
                        P.getNome().equalsIgnoreCase(playlists.get(i).getNome()) && P.getId() != playlists.get(i).getId()){
                    return true;
                }
            }
        }

        return false;
    }

    public void add(Playlist p) {
        playlists.add(p);
    }

    public ArrayList<Playlist> getPlaylists() {
        ArrayList<Playlist> copia = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++){
            copia.add(new Playlist(playlists.get(i)));
        }

        return copia;
    }

    public void addMusica(Playlist p, Musica musicaEsc) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getId() == p.getId()){
                playlists.get(i).getMusicas().add(musicaEsc);
                p.getMusicas().add(musicaEsc);
                break;
            }
        }
    }

    public void remMusica(Playlist p, int idMusica) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getId() == p.getId()){

                for (int j = 0; j < playlists.get(i).getMusicas().size(); j++){
                    if (playlists.get(i).getMusicas().get(j).getId() == idMusica){
                        playlists.get(i).getMusicas().remove(j);
                        p.getMusicas().remove(j);
                        break;
                    }
                }
            }
        }
    }

    public void compartilharComUsuario(Playlist p, Usuario u) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getId() == p.getId()){
                playlists.get(i).getUsuariosCompartilhados().add(u);
                break;
            }
        }
    }

    public void edit(Playlist P) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getId() == P.getId()){
                playlists.set(i, P);
                break;
            }
        }
    }

    public void excluir(Playlist P) {
        for (int i = 0; i < playlists.size(); i++){
            if (playlists.get(i).getId() == P.getId()){
                playlists.remove(i);
                break;
            }
        }
    }

    public void atualizarMusica(Musica M) {
        for (int i = 0; i < playlists.size(); i++){
            for (int j = 0; j < playlists.get(i).getMusicas().size(); j++){
                if (playlists.get(i).getMusicas().get(j).getId() == M.getId()){
                    playlists.get(i).getMusicas().set(j, new Musica(M));
                    break;
                }
            }
        }
    }
}
