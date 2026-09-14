package ui;

import negocio.Avaliacao;
import negocio.Musica;
import negocio.Sistema;
import negocio.Usuario;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UIavaliacoes {
    Scanner scn = new Scanner(System.in).useLocale(Locale.US);

    public void menuInicial(Usuario U) {
        int opcao;
        Sistema S = Sistema.getInstance();
        String formatoM = "%-4s %-25s %-25s %-15s %-1s";

        do {
            System.out.println("--------------------------------------------");
            System.out.println("0 - SAIR");
            System.out.println("1 - Fazer a avaliação de uma música");
            System.out.println("2 - Editar a avaliação de uma música");
            System.out.println("3 - Excluir a avaliação de uma música");
            System.out.println("4 - Ver avaliações já feitas por você");
            System.out.println("5 - Listar avaliações de uma música");
            opcao = scn.nextInt();

            System.out.println("--------------------------------------------");

            switch (opcao){
                case 1: { // FAZER AVALIAÇÃO DE MÚSICA
                    ArrayList<Musica> copiaM = S.pegarVetorMusicas();

                    if (copiaM.isEmpty()){
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        ArrayList<Musica> naoAvaliadas = S.pegarMusicasNaoAvaliadas(U, copiaM);

                        if (naoAvaliadas.isEmpty()){
                            System.out.println("Você já avaliou todas as músicas da plataforma pelo menos 1 vez");
                        } else {
                            S.exibirMusicas(naoAvaliadas);

                            System.out.println("Insira o ID da música que deseja avaliar");

                            int idMusica;
                            Musica musicaEsc = null;
                            boolean existe = false;

                            do {
                                idMusica = scn.nextInt();

                                for (int i = 0; i < copiaM.size(); i++) {
                                    if (idMusica == copiaM.get(i).getId()) {
                                        musicaEsc = copiaM.get(i);
                                        existe = true;
                                        break;
                                    }
                                }

                                if (!existe)
                                    System.out.println("Insira um ID válido");

                            } while (!existe);

                            Avaliacao A = null;

                            do {
                                double nota;
                                String descricao;

                                do {
                                    System.out.println("Nota (0 a 10)");
                                    nota = scn.nextDouble();
                                    scn.nextLine();
                                } while (nota < 0 || nota > 10);

                                System.out.println("Descricao:");
                                descricao = scn.nextLine();

                                A = Avaliacao.getInstance(nota, descricao, musicaEsc, U);
                            } while (A == null);

                            S.adicionarAvaliacao(A);
                            System.out.println("Avaliação adicionada com sucesso");
                        }
                    }
                    break;
                }
                case 2:{
                    ArrayList<Avaliacao> AvFeitasPorUsuario = S.pegarAvaliacoesUsuario(U);

                    if (AvFeitasPorUsuario.isEmpty()){
                        System.out.println("Nenhuma avaliação feita pelo usuário");
                    } else {
                        S.exibirAvaliacoes(AvFeitasPorUsuario, true);
                        System.out.println("Insira o ID da avaliação que deseja editar");

                        int idAvaliacao;
                        Avaliacao AvEsc = null;
                        boolean existe = false;

                        do {
                            idAvaliacao = scn.nextInt();

                            for (int i = 0; i < AvFeitasPorUsuario.size(); i++) {
                                if (idAvaliacao == AvFeitasPorUsuario.get(i).getId()) {
                                    AvEsc = AvFeitasPorUsuario.get(i);
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        double nota;
                        String descricao;

                        do {
                            System.out.println("Nota (0 a 10) [" + String.format("%", AvEsc.getNota()) + "]:");
                            nota = scn.nextInt();
                            scn.nextLine();
                        } while (nota < 0 || nota > 10);

                        System.out.println("Descricao:");
                        descricao = scn.nextLine();

                        AvEsc.setNota(nota);
                        AvEsc.setDescricao(descricao);

                        S.alterarAvaliacao(AvEsc);
                        System.out.println("Avaliação editada com sucesso");
                    }
                    break;
                }
                case 3: {
                    ArrayList<Avaliacao> AvFeitasPorUsuario = S.pegarAvaliacoesUsuario(U);

                    if (AvFeitasPorUsuario.isEmpty()){
                        System.out.println("Nenhuma avaliação feita pelo usuário");
                    } else {
                        S.exibirAvaliacoes(AvFeitasPorUsuario, true);
                        System.out.println("Insira o ID da avaliação que deseja editar");

                        int idAvaliacao;
                        Avaliacao AvEsc = null;
                        boolean existe = false;

                        do {
                            idAvaliacao = scn.nextInt();

                            for (int i = 0; i < AvFeitasPorUsuario.size(); i++) {
                                if (idAvaliacao == AvFeitasPorUsuario.get(i).getId()) {
                                    AvEsc = AvFeitasPorUsuario.get(i);
                                    existe = true;
                                    break;
                                }
                            }

                            if (!existe)
                                System.out.println("Insira um ID válido");

                        } while (!existe);

                        S.deletarAvaliacao(AvEsc);
                        System.out.println("Avaliação excluida com sucesso");
                    }
                    break;
                }
                case 4: {
                    ArrayList<Avaliacao> AvFeitasPorUsuario = S.pegarAvaliacoesUsuario(U);

                    if (AvFeitasPorUsuario.isEmpty()){
                        System.out.println("Nenhuma avaliação feita pelo usuário");
                    } else {
                        S.exibirAvaliacoes(AvFeitasPorUsuario, true);
                    }
                    break;
                }
                case 5: {
                    ArrayList<Musica> copiaM = S.pegarVetorMusicas();

                    if (copiaM.isEmpty()){
                        System.out.println("Nenhuma música cadastrada");
                    } else {
                        S.exibirMusicas(copiaM);
                        System.out.println("Insira o ID da musica que deseja ver as avaliações");
                    }

                    int idMusica;
                    Musica musicaEsc = null;
                    boolean existe = false;

                    do {
                        idMusica = scn.nextInt();

                        for (int i = 0; i < copiaM.size(); i++) {
                            if (idMusica == copiaM.get(i).getId()) {
                                musicaEsc = copiaM.get(i);
                                existe = true;
                                break;
                            }
                        }

                        if (!existe)
                            System.out.println("Insira um ID válido");

                    } while (!existe);

                    ArrayList<Avaliacao> avaliacoesMusica = S.pegarAvaliacoesMusica(musicaEsc);

                    if (avaliacoesMusica.isEmpty()){
                        System.out.println("Nenhuma avaliação da música foi feita");
                    } else {
                        S.exibirAvaliacoes(avaliacoesMusica, false);
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
