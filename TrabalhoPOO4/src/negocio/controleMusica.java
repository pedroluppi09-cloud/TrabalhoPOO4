package negocio;

import repositorio.repositorioMusica;

import java.util.ArrayList;

public class controleMusica {
    private repositorioMusica rMusica;

    public controleMusica() {
        rMusica = new repositorioMusica();
    }

    public void add(Musica M){
        if (rMusica.encontrarMusicaNomeArtistaIguais(M)){
            System.out.println("Não é possível adicionar a musica (Música já cadastrada)");
        } else {
            rMusica.add(M);
        }
    }
}
