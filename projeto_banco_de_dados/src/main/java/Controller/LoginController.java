package controller;

import view.TelaLogin;
import javax.swing.JOptionPane;

public class LoginController {
    private final TelaLogin view; // O Controller "enxerga" a tela

    public LoginController(TelaLogin view) {
        this.view = view; // Quando o controller nasce, ele se liga a uma tela
    }

    // Aqui criaremos as ações
    public void entrarNoSistema() {
        // 1. Coleta
    String usuario = view.getTxtUsuario().getText();
    String senha = new String(view.getTxtSenha().getPassword());

    // 2. Validação simples (Antes de usarmos o Hibernate)
    if (usuario.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
    } else {
        // 3. Resposta (Sucesso)
        System.out.println("Usuário " + usuario + " tentando logar...");
        // Futuramente: chamar o UsuarioDAO aqui
    }

    }
}        