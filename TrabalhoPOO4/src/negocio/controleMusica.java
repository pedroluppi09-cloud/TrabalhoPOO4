package negocio;

import repositorio.repositorioMusica;

import java.util.ArrayList;

public class controleMusica {
    private repositorioMusica rMusica;

    public controleMusica() {
        rMusica = new repositorioMusica();
    }

    public boolean add(Musica M){
        if (rMusica.encontrarMusicaNomeArtistaIguais(M, 'C')){
            System.out.println("Não é possível adicionar a musica (Música já cadastrada)");
            return false;
        } else {
            rMusica.add(M);
            return true;
        }
    }

    public ArrayList<Musica> pegarVetor() {
        return rMusica.getMusicas();
    }

    public boolean alterar(Musica M, int consi) {
        if (rMusica.encontrarMusicaNomeArtistaIguais(M, 'E')){
            System.out.println("Não é possível alterar a musica (Música já cadastrada)");
            return false;
        } else {
            rMusica.edit(M, consi);
            return true;
        }
    }

    public boolean excluir(int consi) {
        Musica m = rMusica.pegarMusicaPelaPosicao(consi);

        if (m.getAvaliacoes().isEmpty()){
            rMusica.delete(consi, 'D'); //definitivo
            return true;
        } else {
            rMusica.delete(consi, 'S'); //softdelete
            return true;
        }
    }
}
