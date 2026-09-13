package ui;

import negocio.Musica;
import negocio.Playlist;
import negocio.Sistema;
import negocio.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UIplaylists {
    static Scanner scn = new Scanner(System.in);

    public void menuInicial(Usuario U, ArrayList<Usuario> usuarios) {
        int opcao;
        Sistema S = Sistema.getInstance();
        UiPlaylistMusica uiPM = new UiPlaylistMusica();

        do {
            System.out.println("0 - SAIR");
            System.out.println("1 - Criar uma playlist");
            System.out.println("2 - Editar informações de playlist");
            System.out.println("3 - Excluir / Remover Playlist");
            System.out.println("4 - Inserir / Remover Música em playlist");
            System.out.println("5 - Listar suas playlists");
            System.out.println("6 - Listar playlists compartilhadas com você");
            System.out.println("7 - Compartilhar playlist com usuário");
            opcao = scn.nextInt();
            scn.nextLine();

            switch (opcao){
                case 1: {
                    boolean adicionou = false;
                    Playlist P = null;
                    String nome;
                    String descricao;

                    do {
                        System.out.println("Nome da Playlist:");
                        nome = scn.nextLine();

                        System.out.println("Descricao: ");
                        descricao = scn.nextLine();

                        P = Playlist.getInstance(nome, descricao, U);

                        if (P == null){
                            System.out.println("Erro no cadastro da playlist");
                        } else {
                            adicionou = S.adicionarPlaylist(P, U.getId());

                            if (adicionou){
                                System.out.println("Playlist adicionada com sucesso!");
                            } else {
                                System.out.println("Erro no cadastro da playlist (você já criou uma cadastrada com esse nome)");
                            }
                        }
                    } while (!adicionou);
                    break;
                }
                case 2:{
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    ArrayList<Playlist> PlaylistsdoUsuario = S.pegarPlaylistsDeUsuario(U);
                    Playlist PlayEscolhida = null;

                    if (PlaylistsdoUsuario.isEmpty()) {
                        System.out.println("Nenhuma playlist cadastrada por você no momento");
                    } else {
                        S.exibirPlaylists(PlaylistsdoUsuario);
                        System.out.println("Selecione o ID da playlist que deseja adicionar / remover música");

                        boolean existe = false;

                        do {
                            int idPlaylist = scn.nextInt();

                            for (int i = 0; i < PlaylistsdoUsuario.size(); i++) {
                                if (PlaylistsdoUsuario.get(i).getId() == idPlaylist) {
                                    PlayEscolhida = PlaylistsdoUsuario.get(i);
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);
                    }

                    uiPM.menuPrincipal(PlayEscolhida);
                    break;
                }
                case 5: {
                    ArrayList<Playlist> PlaylistsdoUsuario = S.pegarPlaylistsDeUsuario(U);

                    if (PlaylistsdoUsuario.isEmpty()){
                        System.out.println("Nenhuma playlist cadastrada por você no momento");
                    } else {
                        S.exibirPlaylists(PlaylistsdoUsuario);
                    }
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                default: {
                    break;
                }
            }
        } while (opcao != 0);


    }
}
