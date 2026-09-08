package negocio;

import java.util.ArrayList;

public class Sistema {
    private controlePlaylist cPlaylist;
    private controleMusica cMusica;
    private controleAvaliacao cAvaliacao;

    private static Sistema instance;

    private Sistema() {
        cPlaylist = new controlePlaylist();
        cMusica = new controleMusica();
        cAvaliacao = new controleAvaliacao();
    }

    public static Sistema getInstance() {
        if (instance == null)
            instance = new Sistema();

        return instance;
    }

    public boolean adicionarMusica(Musica M) {
        return cMusica.add(M);
    }

    public ArrayList<Musica> pegarVetorMusicas() {
        return cMusica.pegarVetor();
    }
}
