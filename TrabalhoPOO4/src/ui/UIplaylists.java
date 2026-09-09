package ui;

import negocio.Usuario;

import java.util.ArrayList;

public class UIplaylists {
    public void menuInicial(Usuario U, ArrayList<Usuario> usuarios) {
        System.out.println("0 - SAIR");
        System.out.println("1 - Criar uma playlist");
        System.out.println("2 - Inserir Música em playlist");
        System.out.println("3 - Remover Música de playlist");
        System.out.println("4 - Editar informações de playlist");
        System.out.println("5 - Excluir Playlist");
        System.out.println("6 - Listar suas playlists");
        System.out.println("7 - Compartilhar playlist com usuário");
        System.out.println("8 - Criar playlist com formulário");
    }
}
