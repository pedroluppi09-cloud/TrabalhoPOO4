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

    public void edit(Musica M, int i) {
        musicas.set(i, M);
    }

    public ArrayList<Musica> getMusicas() {
        ArrayList<Musica> copia = new ArrayList<>();

        for (int i = 0; i < musicas.size(); i++){
            copia.add(new Musica(musicas.get(i)));
        }

        return copia;
    }

    public boolean encontrarMusicaNomeArtistaIguais(Musica M, char funcao) {
        boolean NomeEArtistaRepete = false;

        for (int i = 0; i < musicas.size(); i++){
            if (funcao == 'C'){
                if (M.getNome().equalsIgnoreCase(musicas.get(i).getNome()) &&
                        M.getArtista().equalsIgnoreCase(musicas.get(i).getArtista())) {
                    NomeEArtistaRepete = true;
                    break;
                }
            }

            if (funcao == 'E'){
                if (M.getNome().equalsIgnoreCase(musicas.get(i).getNome()) &&
                        M.getArtista().equalsIgnoreCase(musicas.get(i).getArtista()) && M.getId() != musicas.get(i).getId()) {
                    NomeEArtistaRepete = true;
                    break;
                }
            }
        }

        return NomeEArtistaRepete;
    }

    public void delete(int id, char tipo) {
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getId() == id){
                if (tipo == 'D'){
                    musicas.remove(i);
                    break;
                }

                if (tipo == 'S'){
                    musicas.get(i).setExcluido(true);
                    break;
                }
            }
        }
    }
}
