package ui;

import negocio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UIplaylists {
    static Scanner scn = new Scanner(System.in);

    public void menuInicial(Usuario U, ArrayList<Usuario> TodosUs) {
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
            System.out.println("7 - Listar músicas de uma Playlist");
            System.out.println("8 - Compartilhar playlist com usuário");
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
                case 2: {
                    boolean existe = false;
                    int idPlaylist;
                    Playlist playlistEsc = null;

                    ArrayList<Playlist> PlaylistsdoUsuario = S.pegarPlaylistsDeUsuario(U);
                    S.exibirPlaylists(PlaylistsdoUsuario);

                    System.out.println("Escolha o ID da playlist que deseja alterar");

                    do {
                        idPlaylist = scn.nextInt();

                        for (int i = 0; i < PlaylistsdoUsuario.size(); i++) {
                            if (PlaylistsdoUsuario.get(i).getId() == idPlaylist) {
                                existe = true;
                                playlistEsc = PlaylistsdoUsuario.get(i);
                                break;
                            }
                        }

                        if (!existe)
                            System.out.println("Insira um ID válido");

                    } while (!existe);

                    String nome;
                    String descricao;
                    scn.nextLine();

                    boolean alterou = false;

                    do {
                        do {
                            System.out.println("Nome da Playlist [" + playlistEsc.getNome() + "]:");
                            nome = scn.nextLine();
                        } while (nome.isEmpty());

                        do {
                            System.out.println("Descricao:");
                            descricao = scn.nextLine();
                        } while (descricao.isEmpty());

                        playlistEsc.setNome(nome);
                        playlistEsc.setDescricao(descricao);

                        alterou = S.alterarPlaylist(playlistEsc, U.getId());
                    } while (!alterou);

                    break;
                }
                case 3: {
                    boolean existe = false;
                    int idPlaylist;
                    Playlist playlistEsc = null;

                    ArrayList<Playlist> PlaylistsdoUsuario = S.pegarPlaylistsDeUsuario(U);
                    S.exibirPlaylists(PlaylistsdoUsuario);

                    System.out.println("Escolha o ID da playlist que deseja excluir");

                    do {
                        idPlaylist = scn.nextInt();

                        for (int i = 0; i < PlaylistsdoUsuario.size(); i++) {
                            if (PlaylistsdoUsuario.get(i).getId() == idPlaylist) {
                                existe = true;
                                playlistEsc = PlaylistsdoUsuario.get(i);
                                break;
                            }
                        }

                        if (!existe)
                            System.out.println("Insira um ID válido");

                    } while (!existe);

                    String nome;
                    String descricao;

                    boolean excluiu = S.excluirPlaylist(playlistEsc);

                    if (!excluiu){
                        System.out.println("Ocorreu algum erro na exclusão");
                    } else {
                        System.out.println("Playlist excluída com sucesso");
                    }

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

                        uiPM.menuPrincipal(PlayEscolhida);
                    }
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
                    ArrayList<Playlist> PlaylistsCompartilhadas = S.pegarPlaylistsCompartilhadas(U);

                    if (PlaylistsCompartilhadas.isEmpty()){
                        System.out.println("Nenhuma playlist compartilhada com você no momento");
                    } else {
                        S.exibirPlaylists(PlaylistsCompartilhadas);
                    }
                    break;
                }
                case 7: {
                    ArrayList<Playlist> Playlists = S.pegarPlaylistsDeUsuarioECompartilhadas(U);

                    if (Playlists.isEmpty()){
                        System.out.println("Nenhuma playlist foi encontrada");
                    } else {
                        S.exibirPlaylists(Playlists);
                        System.out.println("Escolha o ID da playlist que deseja exibir as músicas");

                        boolean existe = false;
                        ArrayList<Musica> musPlaylist = null;

                        do {
                            int idPlaylist = scn.nextInt();

                            for (int i = 0; i < Playlists.size(); i++) {
                                if (Playlists.get(i).getId() == idPlaylist) {
                                    musPlaylist = Playlists.get(i).getMusicas();
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        if (musPlaylist.isEmpty()){
                            System.out.println("Nenhuma música inserida na Playlist");
                        } else {
                            S.exibirMusicas(musPlaylist);
                        }
                    }
                    break;
                }
                case 8: {
                    ArrayList<Playlist> PlaylistsdoUsuario = S.pegarPlaylistsDeUsuario(U);

                    if (PlaylistsdoUsuario.isEmpty()){
                        System.out.println("Nenhuma playlist cadastrada");
                    } else {
                        S.exibirPlaylists(PlaylistsdoUsuario);
                        System.out.println("Selecione o ID da playlist que deseja adicionar / remover música");

                        boolean existe = false;
                        Playlist playEsc = null;

                        do {
                            int idPlaylist = scn.nextInt();

                            for (int i = 0; i < PlaylistsdoUsuario.size(); i++) {
                                if (PlaylistsdoUsuario.get(i).getId() == idPlaylist) {
                                    playEsc = PlaylistsdoUsuario.get(i);
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        ArrayList<Usuario> usNaoCompartilhados = S.pegarUsuariosNaoCompartilhados(playEsc, TodosUs);

                        if (usNaoCompartilhados.isEmpty()){
                            System.out.println("Voce já compartilhou esta playlist com todos os usuários da plataforma");
                        } else {
                            S.exibirUsuarios(usNaoCompartilhados);
                            System.out.println("Insira o ID do usuário com quem você vai compartilahr a playlist");

                            boolean existeU = false;
                            Usuario Ucomp = null;

                            do {
                                int id = scn.nextInt();

                                for(int i = 0; i < TodosUs.size(); i++){
                                    if (TodosUs.get(i).getId() == id && id != U.getId()){
                                        Ucomp = TodosUs.get(i);
                                        existeU = true;
                                        break;
                                    }
                                }

                                if (!existeU)
                                    System.out.println("Usuário não encontrado");
                            } while (!existeU);

                            S.CompartilharPlaylistComUsuario(playEsc, Ucomp);
                            System.out.println("Compartilhamento feito com sucesso");
                        }
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
