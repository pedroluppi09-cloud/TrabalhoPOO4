package negocio;

import repositorio.repositorioAvaliacao;

import java.util.ArrayList;

public class controleAvaliacao {
    repositorioAvaliacao rAvaliacao = new repositorioAvaliacao();

    public ArrayList<Avaliacao> pegarVetor() {
        return rAvaliacao.getAvaliacoes();
    }

    public void add(Avaliacao A) {
        rAvaliacao.add(A);
    }
}
