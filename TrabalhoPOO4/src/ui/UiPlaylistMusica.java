package ui;

import negocio.Musica;
import negocio.Playlist;
import negocio.Sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class UiPlaylistMusica {
    Scanner scn = new Scanner(System.in);

    public void menuPrincipal(Playlist P) {
        Sistema S = Sistema.getInstance();
        int opcao;

        do {
            System.out.println("--------------------------------------------");
            System.out.println("0 - SAIR");
            System.out.println("1 - Adicionar Música");
            System.out.println("2 - Remover Música");
            opcao = scn.nextInt();

            System.out.println("--------------------------------------------");

            switch (opcao){
                case 1:{
                    ArrayList<Musica> naoAdicionadas = S.pegarMusicasNaoAdicionadas(P);

                    if (naoAdicionadas.isEmpty()){
                        System.out.println("Todas as músicas da plataforma já foram adicionadas na sua playlist");
                    } else {
                        S.exibirMusicas(naoAdicionadas);
                        System.out.println("Selecione o ID da música que deseja adicionar na playlist");

                        int idMusica;
                        Musica musicaEsc = null;
                        boolean existe = false;

                        do {
                            idMusica = scn.nextInt();

                            for (int i = 0; i < naoAdicionadas.size(); i++){
                                if (idMusica == naoAdicionadas.get(i).getId()){
                                    musicaEsc = naoAdicionadas.get(i);
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        S.addMusicaEmPlaylist(P, musicaEsc);
                        System.out.println("Musica adicionada com sucesso!");
                    }
                    break;
                }
                case 2:{
                    if (P.getMusicas().isEmpty()){
                        System.out.println("Você não inseriu nenhuma música na sua playlist");
                    } else {
                        S.exibirMusicas(P.getMusicas());
                        System.out.println("Selecione o ID da música que deseja remover da playlist");

                        int idMusica;
                        boolean existe = false;

                        do {
                            idMusica = scn.nextInt();

                            for (int i = 0; i < P.getMusicas().size(); i++){
                                if (idMusica == P.getMusicas().get(i).getId()){
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        S.remMusicaEmPlaylist(P, idMusica);
                        System.out.println("Musica removida com sucesso!");
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);
    }
}
