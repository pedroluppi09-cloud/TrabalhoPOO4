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

    public void sortearMusicaOrdemCcodigoCrescente(ArrayList<Musica> copia) {
        Musica aux;

        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - i - 1; j++) {
                if (copia.get(j).getNotaAtual() > copia.get(j+1).getNotaAtual()) {
                    aux = copia.get(j);
                    copia.set(j, copia.get(j+1));
                    copia.set(j+1, aux);
                }
            }
        }
    }

    public void sortearMusicaOrdemCcodigoDecrescente(ArrayList<Musica> copia) {
        Musica aux;

        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - i - 1; j++) {
                if (copia.get(j).getNotaAtual() < copia.get(j+1).getNotaAtual()) {
                    aux = copia.get(j);
                    copia.set(j, copia.get(j+1));
                    copia.set(j+1, aux);
                }
            }
        }
    }

    public boolean alterarMusica(Musica musicaEsc, int consi) {
        return cMusica.alterar(musicaEsc, consi);
    }

    public boolean excluirMusica(int consi) {
        return cMusica.excluir(consi);
    }
}
