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

    public boolean excluirMusica(int id) {
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();
        return cMusica.excluir(id, copiaA);
    }

    public ArrayList<Avaliacao> pegarVetorAvaliacoes() {
        return cAvaliacao.pegarVetor();
    }

    public ArrayList<Musica> pegarMusicasNaoAvaliadas(Usuario U, ArrayList<Musica> copiaM) {
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();
        ArrayList<Musica> naoAvaliadas = new ArrayList<>();

        for (int i = 0; i < copiaM.size(); i++){
            boolean avaliadaPeloUsuario = false;

            for (int j = 0; j < copiaA.size(); j++) {
                if (copiaA.get(i).getMusica().getId() == copiaM.get(i).getId() &&
                        copiaA.get(i).getUsuario().getId() == U.getId()) {
                    avaliadaPeloUsuario = true;
                    break;
                }
            }

            if (!avaliadaPeloUsuario) {
                naoAvaliadas.add(copiaM.get(i));
            }
        }

        return naoAvaliadas;
    }

    public void exibirMusicas(ArrayList<Musica> musicas) {
        String formato = "%-4s %-25s %-25s %-15s %-1s";

        System.out.printf(formato, "ID", "NOME", "ARTISTA", "NOTA ATUAL", "GENERO");
        System.out.println();

        for (int i = 0; i < musicas.size(); i++){
            musicas.get(i).imprimirColuna(formato);
            System.out.println();
        }
    }

    public void adicionarAvaliacao(Avaliacao A) {
        cAvaliacao.add(A);
    }
}
