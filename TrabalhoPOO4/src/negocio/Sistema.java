package negocio;

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

    public void adicionarMusica(Musica M) {
        cMusica.add(M);
    }
}
