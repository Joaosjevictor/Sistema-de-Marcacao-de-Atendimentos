package controller;

import view.TelaLogin;
import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginController {
    private final TelaLogin view; // O Controller "enxerga" a tela

    public LoginController(TelaLogin view) {
        this.view = view; // Quando o controller nasce, ele se liga a uma tela
    }

    // Aqui criaremos as ações
    public void entrarNoSistema() {
        // 1. Coleta
    String email = view.getTxtUsuario().getText();
    String senha = new String(view.getTxtSenha().getPassword());

    // 2. Validação simples (Antes de usarmos o Hibernate)
    if (email.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
    } else {
        // 3. Resposta (Sucesso)
        System.out.println("Usuário " + email + " tentando logar...");
        // Futuramente: chamar o UsuarioDAO aqui
        UsuarioDAO dao = new UsuarioDAO();
    Usuario usuarioDoBanco = dao.buscarPorEmail(email); // Método que criamos no DAO

    if (usuarioDoBanco != null && usuarioDoBanco.getSenha().equals(senha)) {
        JOptionPane.showMessageDialog(view, "Bem-vindo, " + usuarioDoBanco.getNome() + "!");
        
        // Abre a próxima tela (ex: TelaServicos)
        new view.TelaServicos().setVisible(true);
        view.dispose();
    } else {
        JOptionPane.showMessageDialog(view, "E-mail ou senha incorretos!");
    }
    }

    }
}        