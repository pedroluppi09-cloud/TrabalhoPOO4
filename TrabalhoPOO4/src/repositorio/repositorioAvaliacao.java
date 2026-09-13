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
            if (!avaliacoes.get(i).getMusica().isExcluido()) {
                copia.add(new Avaliacao(avaliacoes.get(i)));
            }
        }

        return copia;
    }

    public void add(Avaliacao A) {
        avaliacoes.add(A);
    }

    public void edit(Avaliacao a) {
        for (int i = 0; i < avaliacoes.size(); i++){
            if (avaliacoes.get(i).getId() == a.getId()) {
                avaliacoes.set(i, a);
                break;
            }
        }
    }

    public void delete(Avaliacao avEsc) {
        for (int i = 0; i < avaliacoes.size(); i++){
            if (avaliacoes.get(i).getId() == avEsc.getId()){
                avaliacoes.remove(i);
                break;
            }
        }
    }

    public void setExcluidoEmMusica(int id) {
        for (int i = 0; i < avaliacoes.size(); i++){
            if (avaliacoes.get(i).getMusica().getId() == id){
                avaliacoes.get(i).getMusica().setExcluido(true);
            }
        }
    }
}
