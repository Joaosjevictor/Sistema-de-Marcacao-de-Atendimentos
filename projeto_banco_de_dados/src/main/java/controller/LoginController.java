package controller;

import view.TelaLogin;
import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginController {
    private final TelaLogin view;

    public LoginController(TelaLogin view) {
        this.view = view; 
    }

   
    public void entrarNoSistema() {
    String email = view.getTxtUsuario().getText();
    String senha = new String(view.getTxtSenha().getPassword());
    
    if (email.isEmpty() || senha.isEmpty()) {
        JOptionPane.showMessageDialog(view, "Preencha todos os campos!");
    } else {
        System.out.println("Usuário " + email + " tentando logar...");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioDoBanco = dao.buscarPorEmail(email); // Método que criamos no DAO

        if (usuarioDoBanco != null && usuarioDoBanco.getSenha().equals(senha)) {
            JOptionPane.showMessageDialog(view, "Bem-vindo, " + usuarioDoBanco.getNome() + "!");
            util.Sessao.setUsuario(usuarioDoBanco);

            new view.TelaServicos().setVisible(true);
            view.dispose();
        } else {
        JOptionPane.showMessageDialog(view, "E-mail ou senha incorretos!");
        }
    }

    }

    public void abrirTelaCadastro() {
    new view.TelaCadastro().setVisible(true);
   
    view.dispose();
    }
}        
