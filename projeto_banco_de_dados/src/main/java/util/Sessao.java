package util;

import model.Usuario;

public class Sessao {
    // Variável estática que guarda o usuário na memória RAM enquanto o sistema rodar
    private static Usuario usuarioLogado;

    public static void setUsuario(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioLogado;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
    }
}