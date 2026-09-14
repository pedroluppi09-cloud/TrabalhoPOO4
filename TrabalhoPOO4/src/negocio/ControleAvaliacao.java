package negocio;

import repositorio.RepositorioAvaliacao;

import java.util.ArrayList;

public class ControleAvaliacao {
    RepositorioAvaliacao rAvaliacao = new RepositorioAvaliacao();

    public ArrayList<Avaliacao> pegarVetor() {
        return rAvaliacao.getAvaliacoes();
    }

    public void add(Avaliacao A) {
        rAvaliacao.add(A);
    }

    public void editar(Avaliacao A) {
        rAvaliacao.edit(A);
    }

    public void excluir(Avaliacao avEsc) {
        rAvaliacao.delete(avEsc);
    }

    public void colocaAvaliacaoComMusicaExcluida(int id) {
        rAvaliacao.setExcluidoEmMusica(id);
    }
}
