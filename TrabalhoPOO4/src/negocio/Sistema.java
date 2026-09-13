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

    public void sortearMusicaNotaCrescente(ArrayList<Musica> copia) {
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

    public void sortearMusicaNotaDecrescente(ArrayList<Musica> copia) {
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

    public boolean excluirMusica(Musica M) {
        boolean temAvalicao = verMusicaTemAvaliacao(M.getId());

        if (temAvalicao) {
            ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();

            for (int i = 0; i < copiaA.size(); i++) {
                if (copiaA.get(i).getMusica().getId() == M.getId()) {
                    colocaAvaliacaoComMusicaExcluida(copiaA.get(i).getId());
                }
            }
        }

        return cMusica.excluir(M.getId(), temAvalicao);
    }

    private void colocaAvaliacaoComMusicaExcluida(int id) {
        cAvaliacao.colocaAvaliacaoComMusicaExcluida(id);
    }

    private boolean verMusicaTemAvaliacao(int id) {
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();

        for (int i = 0; i < copiaA.size(); i++){
            if (copiaA.get(i).getMusica().getId() == id){
                return true;
            }
        }

        return false;
    }

    public ArrayList<Avaliacao> pegarVetorAvaliacoes() {
        return cAvaliacao.pegarVetor();
    }

    public ArrayList<Musica> pegarMusicasNaoAvaliadas(Usuario U, ArrayList<Musica> copiaM) {
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();
        ArrayList<Musica> naoAvaliadas = new ArrayList<>();

        for (int i = 0; i < copiaM.size(); i++) {
            boolean avaliadaPeloUsuario = false;

            for (int j = 0; j < copiaA.size(); j++) {
                if (copiaA.get(j).getMusica().getId() == copiaM.get(i).getId() &&
                        copiaA.get(j).getUsuario().getId() == U.getId()) {
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
        atualizarNotaMusica(A.getMusica().getId());
    }

    public ArrayList<Avaliacao> pegarAvaliacoesUsuario(Usuario U) {
        ArrayList<Avaliacao> avaliacoesUs = new ArrayList<>();
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();

        for (int i = 0; i < copiaA.size(); i++){
            if (copiaA.get(i).getUsuario().getId() == U.getId()){
                avaliacoesUs.add(copiaA.get(i));
            }
        }

        return avaliacoesUs;
    }

    public void exibirAvaliacoes(ArrayList<Avaliacao> avFeitasPorUsuario, boolean listarMusica) {
        for (int i = 0; i < avFeitasPorUsuario.size(); i++){
            if (listarMusica){
                System.out.println("ID " + avFeitasPorUsuario.get(i).getId() + " | " + avFeitasPorUsuario.get(i).getUsuario().getNome()
                        + " | " + avFeitasPorUsuario.get(i).getMusica().getNome());
            } else {
                System.out.println("ID " + avFeitasPorUsuario.get(i).getId() + " | " + avFeitasPorUsuario.get(i).getUsuario().getNome());
            }

            System.out.println("NOTA: " + avFeitasPorUsuario.get(i).getNota() + "/10");
            System.out.println("DESCRICAO: " + avFeitasPorUsuario.get(i).getDescricao());

            System.out.println();
        }
    }

    public void alterarAvaliacao(Avaliacao A) {
        cAvaliacao.editar(A);
        atualizarNotaMusica(A.getMusica().getId());
    }

    public void deletarAvaliacao(Avaliacao A) {
        cAvaliacao.excluir(A);
        atualizarNotaMusica(A.getMusica().getId());
    }

    public ArrayList<Avaliacao> pegarAvaliacoesMusica(Musica M) {
        ArrayList<Avaliacao> avaliacoesMu = new ArrayList<>();
        ArrayList<Avaliacao> copiaA = pegarVetorAvaliacoes();

        for (int i = 0; i < copiaA.size(); i++){
            if (copiaA.get(i).getMusica().getId() == M.getId()){
                avaliacoesMu.add(copiaA.get(i));
            }
        }

        return avaliacoesMu;
    }

    private void atualizarNotaMusica(int idMusica) {
        ArrayList<Musica> copiaM = pegarVetorMusicas();
        Musica musicaEsc = null;

        for (int i = 0; i < copiaM.size(); i++){
            if (copiaM.get(i).getId() == idMusica){
                musicaEsc = copiaM.get(i);
                break;
            }
        }

        ArrayList<Avaliacao> avaliacoesMusica = pegarAvaliacoesMusica(musicaEsc);
        double novaNota = 0;

        if (!avaliacoesMusica.isEmpty()){
            double soma = 0;

            for (int i = 0; i < avaliacoesMusica.size(); i++){
                soma += avaliacoesMusica.get(i).getNota();
            }

            novaNota = soma / avaliacoesMusica.size();
        }

        if (musicaEsc != null) {
            musicaEsc.setNotaAtual(novaNota);
            cMusica.atualizarNota(musicaEsc);
        }
    }
}
