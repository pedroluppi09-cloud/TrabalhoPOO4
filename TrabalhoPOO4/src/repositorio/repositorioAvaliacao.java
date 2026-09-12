package repositorio;

import negocio.Avaliacao;

import java.util.ArrayList;

public class repositorioAvaliacao {
    ArrayList<Avaliacao> avaliacoes;

    public repositorioAvaliacao() {
        avaliacoes = new ArrayList<>();
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        ArrayList<Avaliacao> copia = new ArrayList<>();

        for (int i = 0; i < avaliacoes.size(); i++){
            copia.add(new Avaliacao(avaliacoes.get(i)));
        }

        return copia;
    }

    public void add(Avaliacao A) {
        avaliacoes.add(A);
    }
}
