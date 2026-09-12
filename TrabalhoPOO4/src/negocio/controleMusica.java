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

    public boolean excluir(int id, ArrayList<Avaliacao> Av) {
        boolean temAvaliacao = false;

        for (int i = 0; i < Av.size(); i++){
            if (Av.get(i).getMusica().getId() == id){
                temAvaliacao = true;
                break;
            }
        }

        if (!temAvaliacao){
            rMusica.delete(id, 'D'); //delete padrao
        } else {
            rMusica.delete(id, 'S'); //soft delete
        }

        return true;
    }
}
